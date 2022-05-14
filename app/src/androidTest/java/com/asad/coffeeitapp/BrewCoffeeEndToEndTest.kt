package com.asad.coffeeitapp

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.asad.coffeeitapp.core.di.module.DatabaseModule
import com.asad.coffeeitapp.core.di.module.NetworkModule
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
@UninstallModules(DatabaseModule::class, NetworkModule::class)
class BrewCoffeeEndToEndTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
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
}
