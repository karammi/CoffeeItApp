package com.asad.coffeeitapp.splash.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.asad.coffeeitapp.R

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenContent()
}

@Composable
fun SplashScreenContent() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Dark Roasted Beans")
            Text(text = "Tab the machine to start")
            Image(
                painter = painterResource(id = R.drawable.near_device),
                contentDescription = "device",
                modifier = Modifier.weight(1f)
            )
        }
    }
}
