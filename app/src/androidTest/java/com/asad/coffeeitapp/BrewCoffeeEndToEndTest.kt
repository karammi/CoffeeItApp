package com.asad.coffeeitapp

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.TestTags
import com.asad.coffeeitapp.core.di.Util
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import com.asad.coffeeitapp.data.dataSource.remote.SuccessDispatcher
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class BrewCoffeeEndToEndTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)
//    val hiltRule by lazy { HiltAndroidRule(this) }

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()
//    val composeRule by lazy { createAndroidComposeRule<MainActivity>() }

    //    val mockWebServer by lazy { MockWebServer() }
    val mockWebServer = MockWebServer()
    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        mockWebServer.start(Util.URL_PORT)
        val httpUrl: HttpUrl = mockWebServer.url("/coffee-machine/60ba1ab72e35f2d9c786c610")
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
        println(httpUrl)
        println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @ExperimentalMaterialApi
    @InternalCoroutinesApi
    fun setMainContent() {
        composeRule.setContent {
            viewModel = hiltViewModel()
            CoffeeITAppTheme {
                CoffeeItGraph()
            }
        }
    }

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
