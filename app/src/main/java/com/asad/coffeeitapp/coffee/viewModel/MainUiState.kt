package com.asad.coffeeitapp.coffee.viewModel

import com.asad.coffeeitapp.core.UiState
import com.asad.coffeeitapp.domain.model.CoffeeMachineModel
import com.asad.coffeeitapp.domain.model.ExtraModel
import com.asad.coffeeitapp.domain.model.SizeModel
import com.asad.coffeeitapp.domain.model.SubSelectionModel
import com.asad.coffeeitapp.domain.model.TypeModel

data class MainUiState(
    val coffeeMachine: UiState<CoffeeMachineModel, String> = UiState.Loading,
    val isLoading: Boolean = false,
    val selectedStyle: UiState<TypeModel, String> = UiState.Empty,
    val selectedSize: UiState<SizeModel, String> = UiState.Empty,
    val selectedExtra: UiState<ExtraModel, String> = UiState.Empty,
    val selectedSubSelection: UiState<SubSelectionModel, String> = UiState.Empty,
    val navigateTo: String? = null,
    val sizeList: List<SizeModel>? = mutableListOf(),
    val extraList: List<ExtraModel>? = mutableListOf(),
)
