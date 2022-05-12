package com.asad.coffeeitapp.coffee.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asad.coffeeitapp.core.Result
import com.asad.coffeeitapp.core.UiState
import com.asad.coffeeitapp.domain.model.*
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MAIN_VIEW_MODEL"

data class MainUiState(
    val coffeeMachine: UiState<CoffeeMachineModel, String> = UiState.Loading,
    val isLoading: Boolean = false,
    val selectedStyle: UiState<TypeModel, String> = UiState.Empty,
    val selectedSize: UiState<SizeModel, String> = UiState.Empty,
    val selectedExtra: UiState<ExtraModel, String> = UiState.Empty,
    val selectedSubSelection: UiState<SubSelectionModel, String> = UiState.Empty,
    val navigateTo: String? = null,
    val sizeList: List<SizeModel>? = mutableListOf(),
//    val extraList: List<ExtraModel>? = mutableListOf(),
    val extraList: List<ExtraModel>? = mutableListOf(),
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CoffeeMachineRepository,
) : ViewModel() {

    val uiState = MutableStateFlow(MainUiState())

    init {
        viewModelScope.launch {
            val response = repository.fetchCoffeeMachineInfo(id = "60ba1ab72e35f2d9c786c610")
            when (response) {
                is Result.Error -> {
                    Log.d(TAG, response.apiErrorBody.message.toString())
                    uiState.emit(value = uiState.value.copy(coffeeMachine = UiState.Error(response.apiErrorBody.message!!)))
                }
                Result.Loading -> {
                    uiState.emit(value = uiState.value.copy(coffeeMachine = UiState.Loading))
                }
                is Result.Success -> {
                    Log.d(TAG, response.data.toString())
                    uiState.emit(value = uiState.value.copy(coffeeMachine = UiState.Success(response.data)))
                }
            }
        }
    }

    fun setSelectedStyle(typeModel: TypeModel) {
        viewModelScope.launch {
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
        Log.e(TAG, "############test##################")
        Log.e(TAG, uiState.value.sizeList.toString())
    }

    fun setSelectedSize(sizeModel: SizeModel) {
        viewModelScope.launch {
            uiState.emit(
                value = uiState.value.copy(selectedSize = UiState.Success(sizeModel))
            )
        }
    }

    fun setSelectedExtra(extraModel: ExtraModel, subSelectionModel: SubSelectionModel) {
        viewModelScope.launch {
            uiState.emit(
                value = uiState.value.copy(
                    selectedExtra = UiState.Success(extraModel),
                    selectedSubSelection = UiState.Success(subSelectionModel)
                )
            )
        }
    }
}
