package com.asad.coffeeitapp.extra.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asad.coffeeitapp.Screen
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.splash.screen.ConfigStatusBar

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

    ConfigStatusBar()
    val uiState = mainViewModel.uiState.collectAsState()

    val extra by remember(uiState.value) {
        derivedStateOf { uiState.value.extraList }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = "back",
                        tint = Color.Black,
                        modifier = Modifier.clickable { navController.navigateUp() }
                    )
                    Text(
                        text = "Dark Roasted Beans",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn {
            item {
                Text(
                    text = "Select your Extra",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp
                )
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
