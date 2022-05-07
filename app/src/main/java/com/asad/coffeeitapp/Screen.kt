package com.asad.coffeeitapp

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = ScreenConstants.SplashScreen)
}
