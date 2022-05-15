package com.asad.coffeeitapp.splash.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asad.coffeeitapp.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenContent(navController)
}

@Composable
fun SplashScreenContent(navController: NavController) {

    ConfigStatusBar()

    var phonePosition by remember {
        mutableStateOf(PhonePosition.Left)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Dark Roasted Beans",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = "Tab the machine to start", modifier = Modifier.padding(16.dp).weight(0.2f),
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp
            )
            Box(modifier = Modifier.fillMaxSize().weight(0.8f)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_coffee_machine),
                    contentDescription = "coffee",
                    modifier = Modifier.align(Alignment.Center)

                )
                Image(
                    painter = painterResource(id = R.drawable.ic_nfc_device),
                    contentDescription = "nfc",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Text(
                text = "How does this work",
                fontStyle = FontStyle.Italic,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .weight(0.2f)
                    .align(alignment = Alignment.CenterHorizontally),
                textDecoration = TextDecoration.Underline,

            )
        }
    }
}

enum class PhonePosition {
    Left, Right
}

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
