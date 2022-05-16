package com.asad.coffeeitapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import app.cash.turbine.test
import com.asad.coffeeitapp.coffee.viewModel.MainUiState
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.di.Util
import com.asad.coffeeitapp.core.di.module.DatabaseModule
import com.asad.coffeeitapp.core.di.module.NetworkModule
import com.asad.coffeeitapp.core.enqueueResponse
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import com.asad.coffeeitapp.data.dataSource.remote.CoffeeMachineAPI
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(DatabaseModule::class, NetworkModule::class)
class BrewCoffeeEndToEndTest {

    //    private lateinit var mockWebServer: MockWebServer
    val mockWebServer by lazy { MockWebServer() }

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var api: CoffeeMachineAPI

    @Inject
    lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        mockWebServer.start(port = Util.URL_PORT)
        hiltRule.inject()
        composeRule.setContent {
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testBrewCoffee() = runBlocking {

        mockWebServer.enqueueResponse("success_response_200.json", code = 200)
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).performClick()
//        viewModel.uiState.asStateFlow().test {
//            val emission = awaitItem()
//            Truth.assertThat(emission).isEqualTo(MainUiState())
//            cancelAndConsumeRemainingEvents()
//        }
//        delay(5000)
    }
}
