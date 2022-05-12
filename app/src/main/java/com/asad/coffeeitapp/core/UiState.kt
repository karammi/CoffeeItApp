package com.asad.coffeeitapp.core

sealed class UiState<out R, out T>(open val value: R? = null, open val error: T? = null) {
    object Empty : UiState<Nothing, Nothing>()
    object Loading : UiState<Nothing, Nothing>()
    class Success<T>(override val value: T) : UiState<T, Nothing>()
    class Error<Y>(override val error: Y) : UiState<Nothing, Y>()
}
