package com.asad.coffeeitapp.coffee.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.core.UiState
import com.asad.coffeeitapp.core.di.module.DispatcherProvider
import com.asad.coffeeitapp.domain.model.ExtraModel
import com.asad.coffeeitapp.domain.model.SizeModel
import com.asad.coffeeitapp.domain.model.SubSelectionModel
import com.asad.coffeeitapp.domain.model.TypeModel
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CoffeeMachineRepository,
    private val dispatcherProvider: DispatcherProvider,
) : ViewModel() {

    val uiState = MutableStateFlow(MainUiState())

    init {
        viewModelScope.launch(dispatcherProvider.main) {

            when (
                val response =
                    repository.fetchCoffeeMachineInfo(id = "60ba1ab72e35f2d9c786c610")
            ) {
                is Result.Error -> {
                    uiState.emit(value = uiState.value.copy(coffeeMachine = UiState.Error(response.apiErrorBody.message!!)))
                }
                Result.Loading -> {
                    uiState.emit(value = uiState.value.copy(coffeeMachine = UiState.Loading))
                }
                is Result.Success -> {
                    uiState.emit(value = uiState.value.copy(coffeeMachine = UiState.Success(response.data)))
                }
            }
        }
    }

    fun setSelectedStyle(typeModel: TypeModel) {
        viewModelScope.launch(dispatcherProvider.main) {
            val sizeList = uiState.value.coffeeMachine.value?.sizeModels?.filter {
                typeModel.sizes.contains(it.id)
            }

            val extraList = uiState.value.coffeeMachine.value?.extraModels?.filter {
                typeModel.extras.contains(it.id)
            }
            uiState.emit(
                value = uiState.value.copy(
                    selectedStyle = UiState.Success(typeModel),
                    navigateTo = "",
                    sizeList = sizeList,
                    extraList = extraList
                ),
            )
        }
    }

    fun setSelectedSize(sizeModel: SizeModel) {
        viewModelScope.launch(dispatcherProvider.main) {
            uiState.emit(
                value = uiState.value.copy(selectedSize = UiState.Success(sizeModel))
            )
        }
    }

    fun setSelectedExtra(extraModel: ExtraModel, subSelectionModel: SubSelectionModel) {
        viewModelScope.launch(dispatcherProvider.main) {
            uiState.emit(
                value = uiState.value.copy(
                    selectedExtra = UiState.Success(extraModel),
                    selectedSubSelection = UiState.Success(subSelectionModel)
                )
            )
        }
    }
}
