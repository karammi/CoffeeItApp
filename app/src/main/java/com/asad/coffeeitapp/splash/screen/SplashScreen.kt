package com.asad.coffeeitapp.splash.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.asad.coffeeitapp.R
import com.asad.coffeeitapp.Screen
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.ui.ConfigStatusBar
import com.asad.coffeeitapp.extra.screen.noRippleClickable
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenContent(navController)
}

@Composable
fun SplashScreenContent(navController: NavController) {

    ConfigStatusBar()

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val phonePosition = remember {
        MutableTransitionState(PhonePosition.End)
    }

    val transition = updateTransition(phonePosition, label = "image_transition")

    val phoneTranslationX by transition.animateFloat(
        label = "phone_translation_x",
        transitionSpec = {
            spring(Spring.DampingRatioMediumBouncy, Spring.StiffnessVeryLow)
        }
    ) { state ->
        when (state) {
            PhonePosition.Start -> 0f
            PhonePosition.End -> 100f
        }
    }

    LaunchedEffect(Unit) {
        delay(800)
        phonePosition.targetState = PhonePosition.Start
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
            Box(
                modifier = Modifier.fillMaxWidth().weight(0.6f)
                    .noRippleClickable { navController.navigate(Screen.MainScreen.route) }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_coffee_machine),
                    contentDescription = TestTags.Splash_Screen_CoffeeMachine,
                    modifier = Modifier.align(Alignment.CenterStart)
                        .requiredWidth(screenWidth.times(0.95f)),
                    contentScale = ContentScale.FillBounds,
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_nfc_device),
                    contentDescription = TestTags.Splash_Screen_NFC,
                    modifier = Modifier.align(Alignment.CenterEnd).graphicsLayer {
                        translationX = phoneTranslationX
                    }
                )
            }

            Text(
                text = "How does this work",
                fontStyle = FontStyle.Italic,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
                    .weight(0.2f)
                    .align(alignment = Alignment.CenterHorizontally)
                    .noRippleClickable {
                    },
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}
