package com.asad.coffeeitapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoffeeMachineViewModel @Inject constructor(
    private val repository: CoffeeMachineRepository,
) : ViewModel()
