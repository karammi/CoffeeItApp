package com.asad.coffeeitapp.coffee.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asad.coffeeitapp.Screen
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.ui.CoffeeCardItem

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val uiState = mainViewModel.uiState.collectAsState()

    val navigateTo by remember(uiState) {
        derivedStateOf { uiState.value.navigateTo }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Select your Style")
            LazyColumn {
                uiState.value.coffeeMachine.value?.typeModels?.size?.let { it1 ->
                    items(it1) { index: Int ->
                        uiState.value.coffeeMachine.value?.typeModels?.get(
                            index
                        )?.let { it2 ->
                            CoffeeCardItem(
                                title = it2.name,
                                item = it2,
                                onItemClicked = { selectedTypeModel ->
                                    mainViewModel.setSelectedStyle(selectedTypeModel)
                                    navController.navigate(Screen.SizeScreen.route)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
