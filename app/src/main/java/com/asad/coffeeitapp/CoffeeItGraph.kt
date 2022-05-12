package com.asad.coffeeitapp

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.asad.coffeeitapp.coffee.screen.MainScreen
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.extra.screen.ExtraScreen
import com.asad.coffeeitapp.overview.screen.OverviewScreen
import com.asad.coffeeitapp.size.screen.SizeScreen
import com.asad.coffeeitapp.splash.screen.SplashScreen

@Composable
fun CoffeeItGraph() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable(route = Screen.SizeScreen.route) {
            SizeScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable(route = Screen.ExtraScreen.route) {
            ExtraScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable(route = Screen.OverviewScreen.route) {
            OverviewScreen(navController = navController, mainViewModel = mainViewModel)
        }
    }
}
