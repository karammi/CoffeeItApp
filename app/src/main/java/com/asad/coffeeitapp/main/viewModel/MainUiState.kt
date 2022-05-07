package com.asad.coffeeitapp.main.viewModel

import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import kotlinx.coroutines.flow.MutableStateFlow

data class MainUiState(
    val coffeeMachine: MutableStateFlow<CoffeeMachineModel>,
)
