package com.example.toscas_front.components

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.example.toscas_front.data.model.Movie
import kotlinx.coroutines.launch
import kotlin.math.abs

private const val SWIPE_THRESHOLD_FRACTION = 0.3f
private const val MAX_ROTATION_DEGREES = 15f

@Composable
fun SwipeableMovieStack(
    movies: List<Movie>,
    onSwiped: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    val top = movies.firstOrNull() ?: return
    val visible = movies.take(2)

    val scope = rememberCoroutineScope()
    val currentOnSwiped by rememberUpdatedState(onSwiped)
    var offsetX by remember(top.id) { mutableStateOf(0f) }
    var swipeHandled by remember(top.id) { mutableStateOf(false) }

    BoxWithConstraints(modifier = modifier) {
        val widthPx = constraints.maxWidth.toFloat()
        val threshold = widthPx * SWIPE_THRESHOLD_FRACTION

        visible.asReversed().forEach { movie ->
            key(movie.id) {
                val isTop = movie.id == top.id

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            if (isTop) {
                                translationX = offsetX
                                rotationZ = offsetX / widthPx * MAX_ROTATION_DEGREES
                            } else {
                                val progress = (abs(offsetX) / threshold).coerceIn(0f, 1f)
                                val scale = 0.94f + 0.06f * progress
                                scaleX = scale
                                scaleY = scale
                                alpha = 0.75f + 0.25f * progress
                            }
                        }
                        .then(
                            if (isTop) {
                                Modifier.draggable(
                                    orientation = androidx.compose.foundation.gestures.Orientation.Horizontal,
                                    state = rememberDraggableState { dragAmount ->
                                        if (!swipeHandled) {
                                            offsetX += dragAmount
                                        }
                                    },
                                    onDragStopped = {
                                        scope.launch {
                                            if (abs(offsetX) > threshold && !swipeHandled) {
                                                swipeHandled = true
                                                val direction = if (offsetX > 0) 1f else -1f
                                                animate(
                                                    initialValue = offsetX,
                                                    targetValue = direction * widthPx * 1.5f,
                                                    animationSpec = tween(durationMillis = 250)
                                                ) { value, _ ->
                                                    offsetX = value
                                                }
                                                currentOnSwiped(top)
                                            } else if (!swipeHandled) {
                                                animate(
                                                    initialValue = offsetX,
                                                    targetValue = 0f,
                                                    animationSpec = spring()
                                                ) { value, _ ->
                                                    offsetX = value
                                                }
                                            }
                                        }
                                    }
                                )
                            } else {
                                Modifier
                            }
                        )
                ) {
                    MoviePreview(movie = movie)
                }
            }
        }
    }
}

@Preview
@Composable
fun SwipeableMovieStackPreview() {
    SwipeableMovieStack(
        movies = listOf(
            Movie(1, "Batman", 8.0, null),
            Movie(2, "Interestelar", 8.6, null),
            Movie(3, "Cidade de Deus", 8.4, null)
        ),
        onSwiped = {}
    )
}
