/*
 * Copyright 2023 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package ven.canasta.core.designsystem.theme

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Light default theme color scheme
 */
@VisibleForTesting
val LightDefaultColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.White,
    primaryContainer = Purple90,
    onPrimaryContainer = Purple10,
    secondary = Orange40,
    onSecondary = Color.White,
    secondaryContainer = Orange90,
    onSecondaryContainer = Orange10,
    tertiary = Blue40,
    onTertiary = Color.White,
    tertiaryContainer = Blue90,
    onTertiaryContainer = Blue10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = DarkPurpleGray99,
    onBackground = DarkPurpleGray10,
    surface = DarkPurpleGray99,
    onSurface = DarkPurpleGray10,
    surfaceVariant = PurpleGray90,
    onSurfaceVariant = PurpleGray30,
    inverseSurface = DarkPurpleGray20,
    inverseOnSurface = DarkPurpleGray95,
    outline = PurpleGray50
)




/**
 * Canasta in Android theme.
 */
@Composable
fun CanastaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    content: @Composable () -> Unit
) = CanastaTheme(
    darkTheme = darkTheme,
    androidTheme = androidTheme,
    disableDynamicTheming = false,
    content = content
)


/**
 * Canasta theme. This is an internal only version, to allow disabling dynamic theming
 * in tests.
 **/
@SuppressLint("DesignSystem")
@Composable
internal fun CanastaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean,
    content: @Composable () -> Unit
) {
    // Color scheme
    val colorScheme = LightDefaultColorScheme

    // Gradient colors
    val emptyGradientColors = GradientColors(container = colorScheme.surfaceColorAtElevation(2.dp))
    val defaultGradientColors = GradientColors(
        top = colorScheme.inverseOnSurface,
        bottom = colorScheme.primaryContainer,
        container = colorScheme.surface
    )

    val gradientColors = defaultGradientColors

    // Background theme
    val defaultBackgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp
    )

    val backgroundTheme = defaultBackgroundTheme

    // CompositionLocalProvider(
    //    ven.canasta.apps.grocery.ui.theme.LocalGradientColors provides gradientColors,
    //     LocalBackgroundTheme provides backgroundTheme
    // ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = CanastaTypography,
            content = content
        )
   // }
}


@SuppressLint("DesignSystem")
@Composable
internal fun Eina4Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Eina4Typography,
        content = content
    )
}

@SuppressLint("DesignSystem")
@Composable
internal fun Eina1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Eina1Typography,
        content = content
    )
}

@SuppressLint("DesignSystem")
@Composable
internal fun Eina2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Eina2Typography,
        content = content
    )
}

@SuppressLint("DesignSystem")
@Composable
internal fun Eina3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    androidTheme: Boolean = false,
    disableDynamicTheming: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = LightDefaultColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Eina3Typography,
        content = content
    )
}