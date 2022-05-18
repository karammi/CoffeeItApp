package com.asad.coffeeitapp.coffee.viewModel

import app.cash.turbine.test
import com.asad.coffeeitapp.coffee.COFFEE_MACHINE_FAKE
import com.asad.coffeeitapp.core.UiState
import com.asad.coffeeitapp.core.di.module.TestDispatcher
import com.asad.coffeeitapp.data.repository.FakeCoffeeMachineRepositoryImpl
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    private lateinit var fakeRepository: CoffeeMachineRepository

    private lateinit var testDispatcher: TestDispatcher

    @Before
    fun setup() {
        testDispatcher = TestDispatcher()
        fakeRepository = FakeCoffeeMachineRepositoryImpl()
        viewModel = MainViewModel(fakeRepository, testDispatcher)
    }

    // /todo refactor test to check empty state of the mainUiState
    @Test
    fun `select coffee should be available in the ui state`() = runBlocking {
        viewModel.uiState.asStateFlow().test {
            val emission = awaitItem()
            assertThat(emission).isEqualTo(MainUiState())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `fetching coffee machine should be emit on ui state`() = runBlocking {
        val currentState = MainUiState(coffeeMachine = UiState.Success(COFFEE_MACHINE_FAKE))

        val job = launch {
            viewModel.uiState.asStateFlow().test {
                val emission = awaitItem()
                assertThat(emission).isEqualTo(currentState)
                assertThat(emission.coffeeMachine).isEqualTo(currentState.coffeeMachine)
                cancelAndConsumeRemainingEvents()
            }
        }

        viewModel.uiState.emit(currentState)
        job.join()
        job.cancel()
    }

    @Test
    fun `chose a coffee should emit new ui state`() = runBlocking {
        val currentState = MainUiState(
            coffeeMachine = UiState.Success(COFFEE_MACHINE_FAKE),
            selectedStyle = UiState.Success(COFFEE_MACHINE_FAKE.typeModels[0])
        )
        val job = launch {
            viewModel.uiState.asStateFlow().test {
                val emission = awaitItem()
                assertThat(emission).isEqualTo(currentState)
                assertThat(emission.selectedStyle).isEqualTo(currentState.selectedStyle)
                cancelAndConsumeRemainingEvents()
            }
        }
        viewModel.uiState.emit(currentState)
        job.join()
        job.cancel()
    }

    @Test
    fun `chose a size should emit a new ui state with selected size`() = runBlocking {
        val defaultState = MainUiState(
            coffeeMachine = UiState.Success(COFFEE_MACHINE_FAKE)
        )

        val expectedState = MainUiState(
            coffeeMachine = UiState.Success(COFFEE_MACHINE_FAKE),
            selectedStyle = UiState.Success(COFFEE_MACHINE_FAKE.typeModels[0]),
            sizeList = COFFEE_MACHINE_FAKE.sizeModels.filter {
                COFFEE_MACHINE_FAKE.typeModels[0].sizes.contains(it.id)
            },
            extraList = COFFEE_MACHINE_FAKE.extraModels.filter {
                COFFEE_MACHINE_FAKE.typeModels[0].extras.contains(it.id)
            }
        )
        val job = launch {
            viewModel.uiState.asStateFlow().test {
                awaitItem()
                val emission = awaitItem()

                assertThat(emission).isEqualTo(expectedState)
                cancelAndConsumeRemainingEvents()
            }
        }
        viewModel.uiState.emit(defaultState)
        viewModel.setSelectedStyle(COFFEE_MACHINE_FAKE.typeModels[0])

        job.join()
        job.cancel()
    }
}
