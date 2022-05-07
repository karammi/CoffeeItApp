package com.asad.coffeeitapp

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = ScreenConstants.SplashScreenRoute)
    object MainScreen : Screen(route = ScreenConstants.MainScreenRoute)
}
