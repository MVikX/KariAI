package org.example.kariai.ui.screens.main.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import kotlin.math.max

@Composable
fun ExpandingOverlay(
    isVisible: Boolean,
    origin: Offset,
    onDismiss: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    //TODO автоматику цвета сделать
    val colorBlack = Color.Black


    //анимация масштабирования
    val scale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        label = "scale"
    )


    //фон затемнения
    if (isVisible || scale > 0f) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorBlack.copy(alpha = 0.5f))
                .clickable (onClick = onDismiss),
            contentAlignment = Alignment.TopStart,
        ) {
            Box(
                modifier = Modifier
                    .graphicsLayer (
                        scaleX = scale,
                        scaleY = scale,
                        transformOrigin = androidx.compose.ui.graphics.TransformOrigin(
                            pivotFractionX = origin.x / max(1f, getScreenWidth().toFloat()),
                            pivotFractionY = origin.y / max(1f, getScreenHeight().toFloat())
                        )
                    )
                    .fillMaxSize(),
                content = content
            )
        }
    }
}


//TODO заглушки для размеров экрана
fun getScreenWidth(): Int = 1080
fun getScreenHeight(): Int = 1920