package com.asad.coffeeitapp

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.hilt.navigation.compose.hiltViewModel
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.di.Util
import com.asad.coffeeitapp.core.ui.theme.CoffeeITAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import kotlinx.coroutines.InternalCoroutinesApi
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseScreenTest {
    @get:Rule
    val hiltRule by lazy { HiltAndroidRule(this) }

    @get:Rule
    val composeRule by lazy { createAndroidComposeRule<MainActivity>() }

    val mockWebServer by lazy { MockWebServer() }
    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        mockWebServer.start(Util.URL_PORT)
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
}
