package com.asad.coffeeitapp

import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import app.cash.turbine.test
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import com.asad.coffeeitapp.data.dataSource.remote.FakeData
import com.asad.coffeeitapp.data.dataSource.remote.SuccessDispatcher
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class BrewCoffeeEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var mockWebServer: MockWebServer

    private lateinit var viewModel: MainViewModel

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @ExperimentalMaterialApi
    @InternalCoroutinesApi
    @Before
    fun setUp() {
        hiltRule.inject()
        mockWebServer = MockWebServer()
//        mockWebServer.useHttps( .localhost().socketFactory, false);
        mockWebServer.start(port = 8080)

        composeRule.setContent {
            viewModel = composeRule.activity.viewModels<MainViewModel>().value
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }

    @Test
    @InternalCoroutinesApi
    fun brewACoffee() {
        mockWebServer.url("/coffee-machine/60ba1ab72e35f2d9c786c610")
        mockWebServer.dispatcher = SuccessDispatcher()

        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).performClick()
//        mockWebServer.takeRequest()
        val expectedValue = Result.Success(data = FakeData.FakeCoffeeMachine)
//        val request = mockWebServer.takeRequest()
        runBlocking {
            delay(5000)
            viewModel.uiState.asStateFlow().test {
//                awaitItem()
                val emission = awaitItem()
//                assertThat(request.path).isEqualTo("/coffee-machine/60ba1ab72e35f2d9c786c610")
                assertThat(emission).isEqualTo(viewModel.uiState.value)
            }
        }

//        val job = launch {
//            viewModel.uiState.asStateFlow().test {
//                awaitItem()
//                val emission = awaitItem()
//                assertThat(emission.coffeeMachine).isEqualTo(FakeData.FakeCoffeeMachine)
// //                cancelAndConsumeRemainingEvents()
//            }
//        }
// //        viewModel.uiState.emit(value = MainUiState(coffeeMachine = UiState.Success(value = FakeData.FakeCoffeeMachine)))
//        job.join()
//        IdlingRegistry.getInstance().register(OkHttp3IdlingResource.create("okhttp", okHttp))
    }

//    @get:Rule(order = 0)
//    val hiltRule = HiltAndroidRule(this)
//
//    @get:Rule(order = 1)
//    val composeRule = createAndroidComposeRule<MainActivity>()
//
//    private val mockWebServer = MockWebServer()
//
//    private lateinit var viewModel: MainViewModel

/*    @InternalCoroutinesApi
    @Before
    fun setup() {
        hiltRule.inject()
        mockWebServer.start(Util.URL_PORT)
        composeRule.setContent {
            viewModel = hiltViewModel()
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }*/

    /*@Test
    fun brewCoffee() = runBlocking {
//        mockWebServer.enqueueResponse("success_response_200.json", code = 200)

//        val response = MockResponse().setResponseCode(200).setBody("{}")
//        mockWebServer.enqueue(response)

        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).performClick()

        composeRule.onNodeWithContentDescription(TestTags.MAIN_SCREEN_TITLE).assertIsDisplayed()
        val job = launch {
            viewModel.uiState.asStateFlow().test {
                val emission = awaitItem()
                cancelAndConsumeRemainingEvents()
            }
        }
        viewModel.uiState.emit(value = MainUiState(coffeeMachine = UiState.Success(value = FakeData.FakeCoffeeMachine)))
        job.join()
    }*/
}
