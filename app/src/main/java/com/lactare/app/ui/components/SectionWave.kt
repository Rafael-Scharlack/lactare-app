package com.lactare.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

/**
 * Divisor ondulado ("milk splash") entre seções, referência à identidade visual do Lactare.
 */
@Composable
fun SectionWave(color: Color, modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(28.dp)
    ) {
        val path = Path().apply {
            moveTo(0f, size.height * 0.5f)
            cubicTo(
                size.width * 0.25f, 0f,
                size.width * 0.25f, size.height,
                size.width * 0.5f, size.height * 0.5f
            )
            cubicTo(
                size.width * 0.75f, 0f,
                size.width * 0.75f, size.height,
                size.width, size.height * 0.5f
            )
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        drawPath(path = path, color = color)
    }
}
