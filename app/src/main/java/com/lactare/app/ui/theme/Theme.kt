package com.lactare.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = AzulEscuro,
    onPrimary = Branco,
    secondary = AzulCiano,
    onSecondary = Branco,
    tertiary = Rosa,
    onTertiary = Branco,
    background = Branco,
    onBackground = CinzaTexto,
    surface = Branco,
    onSurface = CinzaTexto,
    surfaceVariant = CinzaFundo,
    onSurfaceVariant = CinzaTexto,
    outline = CinzaBorda,
)

private val DarkColors = darkColorScheme(
    primary = AzulCiano,
    onPrimary = Color(0xFF00243F),
    secondary = AzulEscuro,
    onSecondary = Branco,
    tertiary = Rosa,
    onTertiary = Branco,
    background = Color(0xFF121417),
    onBackground = Branco,
    surface = Color(0xFF1B1E22),
    onSurface = Branco,
    surfaceVariant = Color(0xFF262A2F),
    onSurfaceVariant = Branco,
)

@Composable
fun LactareTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = LactareTypography,
        content = content
    )
}
