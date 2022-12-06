package com.example.udaan.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    /*primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200*/
)

private val LightColorPalette = lightColors(
    primary = light_Primary,
    background = Color.White,
   // primaryVariant = light_PrimaryLight,
    secondary = light_Secondary,
    secondaryVariant = light_SecondaryLight,
    surface = light_surface ,
    onPrimary = light_OnPrimary ,
    onSecondary = light_OnSecondary,
    onBackground = Color.Black,
    onSurface = Color.Black,
    error =  Color.Red,
    onError = Color.Red

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun UDAANTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        //DarkColorPalette
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}