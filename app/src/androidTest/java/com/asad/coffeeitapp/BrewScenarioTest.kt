package com.asad.coffeeitapp

import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.cash.turbine.test
import com.asad.coffeeitapp.coffee.screen.MainScreen
import com.asad.coffeeitapp.coffee.viewModel.MainUiState
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.UiState
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import com.asad.coffeeitapp.core.util.FileReader
import com.asad.coffeeitapp.data.dataSource.remote.FakeData
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class BrewScenarioTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    lateinit var server: MockWebServer

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        server = MockWebServer()
        server.start(port = 8080)
        composeRule.setContent {
            viewModel = hiltViewModel()
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }

    @Test
    fun testFirst() {
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse().setResponseCode(200)
                    .setBody(FileReader.readString("success_response_200.json"))
            }
        }

        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).performClick()
        composeRule.onNodeWithContentDescription(TestTags.MAIN_SCREEN_TITLE).assertIsDisplayed()

        val expectedValue = MainUiState(coffeeMachine = UiState.Success(FakeData.FakeCoffeeMachine))

        runBlocking {
            val job = launch {
                viewModel.uiState.asStateFlow().test {
                    awaitItem()
                    var emission = awaitItem()
                    assertThat(emission).isEqualTo(expectedValue)
                }
            }
            job.join()
            viewModel.uiState.emit(expectedValue)
        }

        composeRule.onAllNodesWithContentDescription("coffee")
            .assertAll(hasContentDescription("coffee"))
        composeRule.onAllNodesWithContentDescription("coffee")[0].assertIsDisplayed()
        composeRule.onAllNodesWithContentDescription("coffee")[0].performClick()
    }

    @Test
    fun testSecond() {
        composeRule.setContent {
//            CoffeeITAppTheme {
//                CoffeeItGraph {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.MainScreen.route
            ) {
                composable(route = Screen.MainScreen.route) {
                    MainScreen(navController = navController)
                }
            }
//                }
//            }
        }
    }
}
