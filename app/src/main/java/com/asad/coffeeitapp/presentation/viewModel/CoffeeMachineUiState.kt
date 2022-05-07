package com.asad.coffeeitapp.presentation.viewModel

import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import kotlinx.coroutines.flow.MutableStateFlow

data class CoffeeMachineUiState(
    val coffeeMachine: MutableStateFlow<CoffeeMachineModel>,
)
