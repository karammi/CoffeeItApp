package com.asad.coffeeitapp.extra.screen

import android.util.Log
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

private const val TAG = "EXTRA_SCREEN"

@Composable
fun ExtraScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    ExtraScreenContent(navController = navController, mainViewModel = mainViewModel)
}

@Composable
fun ExtraScreenContent(navController: NavController, mainViewModel: MainViewModel) {
    val uiState = mainViewModel.uiState.collectAsState()

    val extra by remember(uiState.value) {
        derivedStateOf { uiState.value.extraList }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
            item {
                Text(text = "Select your Extra")
            }
            items(extra!!.size) { index ->
                ExtraCardItem(
                    extraItem = extra!![index],
                    list = extra!![index].subSelectionModels,
                    onItemClicked = { extraModel, subSelectionModel ->
                        Log.d(TAG, "${extraModel.name}----${subSelectionModel?.name}")
                        mainViewModel.setSelectedExtra(
                            extraModel = extraModel,
                            subSelectionModel = subSelectionModel!!
                        )
                        navController.navigate(Screen.OverviewScreen.route)
                    },
                    isClickedSubSelection = false
                )
            }
        }
    }
}
