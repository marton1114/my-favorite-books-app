package com.example.myfavoritebooksapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Brown40,
    onPrimary = Color.White,
    primaryContainer = Brown90,
    onPrimaryContainer = Brown10,
    inversePrimary = Brown80,
    secondary = DarkBrown40,
    onSecondary = Color.White,
    secondaryContainer = DarkBrown90,
    onSecondaryContainer = DarkBrown10,
    tertiary = Green40,
    onTertiary = Color.White,
    tertiaryContainer = Green90,
    onTertiaryContainer = Green10,

    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Grey07,
    onBackground = Grey95,
    surface = BrownGrey15,
    onSurface = BrownGrey80,
    inverseSurface = Grey90,
    inverseOnSurface = Grey10,
    surfaceVariant = BrownGrey15,
    onSurfaceVariant = BrownGrey80,
    surfaceContainer = BrownGrey15,
    outline = BrownGrey80
)

private val LightColorScheme = lightColorScheme(
    primary = Brown40,
    onPrimary = Color.White,
    primaryContainer = Brown90,
    onPrimaryContainer = Brown10,
    inversePrimary = Brown80,
    secondary = DarkBrown40,
    onSecondary = Color.White,
    secondaryContainer = DarkBrown90,
    onSecondaryContainer = DarkBrown10,
    tertiary = Green40,
    onTertiary = Color.White,
    tertiaryContainer = Green90,
    onTertiaryContainer = Green10,

    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Grey99,
    onBackground = Grey10,
    surface = BrownGrey90,
    onSurface = BrownGrey30,
    inverseSurface = Grey20,
    inverseOnSurface = Grey95,
    surfaceVariant = BrownGrey90,
    onSurfaceVariant = BrownGrey30,
    surfaceContainer = BrownGrey90,
    outline = BrownGrey50
)

@Composable
fun MyFavoriteBooksAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}