package com.asad.coffeeitapp.splash.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.asad.coffeeitapp.CoffeeItGraph
import com.asad.coffeeitapp.MainActivity
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.di.module.DatabaseModule
import com.asad.coffeeitapp.core.di.module.NetworkModule
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(DatabaseModule::class, NetworkModule::class)
class SplashScreenKtTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
        composeRule.setContent {
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }

    @Test
    fun afterSplashScreenNavigateToMainScreen() {
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .assertIsDisplayed()

        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .performClick()

        composeRule.onNodeWithContentDescription(TestTags.MAIN_SCREEN_TITLE).assertIsDisplayed()
    }
}
