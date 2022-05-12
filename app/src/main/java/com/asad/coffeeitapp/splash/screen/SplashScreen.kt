package com.asad.coffeeitapp.splash.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.asad.coffeeitapp.R
import com.asad.coffeeitapp.Screen

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenContent(navController)
}

@Composable
fun SplashScreenContent(navController: NavController) {

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Dark Roasted Beans")
            Text(text = "Tab the machine to start")
//            Box(modifier = Modifier.weight(1f)) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_coffee_machine),
//                    contentDescription = "coffee",
//                    modifier = Modifier.align(Alignment.BottomCenter)
//
//                )
//                Image(
//                    painter = painterResource(id = R.drawable.ic_nfc_device),
//                    contentDescription = "nfc"
//                )
//            }
            Image(
                painter = painterResource(id = R.drawable.ic_frame_3),
                contentDescription = "device",
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(Screen.MainScreen.route)
                    }
            )
        }
    }
}
