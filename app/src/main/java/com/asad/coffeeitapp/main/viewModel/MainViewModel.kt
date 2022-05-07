package com.asad.coffeeitapp.main.viewModel

import androidx.lifecycle.ViewModel
import com.asad.coffeeitapp.domain.repository.CoffeeMachineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CoffeeMachineRepository,
) : ViewModel()
