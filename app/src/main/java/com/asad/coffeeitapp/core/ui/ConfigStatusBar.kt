package com.asad.coffeeitapp.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ConfigStatusBar(useDarkIcons: Boolean? = null) {
    val systemUiController = rememberSystemUiController()

    val isThemeLight: Boolean = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons ?: isThemeLight,
        )
    }
}
