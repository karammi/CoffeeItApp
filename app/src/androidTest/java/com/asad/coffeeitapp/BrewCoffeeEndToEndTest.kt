package com.asad.coffeeitapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.di.module.DatabaseModule
import com.asad.coffeeitapp.core.di.module.NetworkModule
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(DatabaseModule::class, NetworkModule::class)
class BrewCoffeeEndToEndTest {

    private lateinit var mockWebServer: MockWebServer

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        hiltRule.inject()
        composeRule.setContent {
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }


}
