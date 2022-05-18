package com.asad.coffeeitapp

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = ScreenConstants.SplashScreenRoute)
    object MainScreen : Screen(route = ScreenConstants.MainScreenRoute)
    object SizeScreen : Screen(route = ScreenConstants.SizeScreenRoute)
    object ExtraScreen : Screen(route = ScreenConstants.ExtraScreenRoute)
    object OverviewScreen : Screen(route = ScreenConstants.OverviewScreenRoute)
}
