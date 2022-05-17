package com.asad.coffeeitapp

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import app.cash.turbine.test
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.data.dataSource.remote.FakeData
import com.asad.coffeeitapp.data.dataSource.remote.SuccessDispatcher
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

@HiltAndroidTest
class BrewCoffeeEndToEndTest : BaseScreenTest() {

    @OptIn(ExperimentalMaterialApi::class)
    @Test
    @InternalCoroutinesApi
    fun brewACoffee() = runBlocking {
        mockWebServer.dispatcher = SuccessDispatcher()

        setMainContent()

        mockWebServer.takeRequest()

        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_CoffeeMachine)
            .assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(TestTags.Splash_Screen_NFC).performClick()
        val job = launch {
            viewModel.uiState.asStateFlow().test {
                awaitItem()
                val emission = awaitItem()
                assertThat(emission.coffeeMachine).isEqualTo(FakeData.FakeCoffeeMachine)
//                cancelAndConsumeRemainingEvents()
            }
        }
//        viewModel.uiState.emit(value = MainUiState(coffeeMachine = UiState.Success(value = FakeData.FakeCoffeeMachine)))
        job.join()
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
