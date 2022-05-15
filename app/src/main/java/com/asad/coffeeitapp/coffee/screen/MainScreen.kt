package com.asad.coffeeitapp.coffee.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asad.coffeeitapp.Screen
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.UiState
import com.asad.coffeeitapp.core.ui.CoffeeCardItem
import com.asad.coffeeitapp.extra.screen.noRippleClickable
import com.asad.coffeeitapp.splash.screen.ConfigStatusBar

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
) {

    ConfigStatusBar()
    val uiState = mainViewModel.uiState.collectAsState()

    val navigateTo by remember(uiState) {
        derivedStateOf { uiState.value.navigateTo }
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
                        modifier = Modifier.noRippleClickable { navController.navigateUp() }
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
        when (uiState.value.coffeeMachine) {
            is UiState.Error -> {
            }
            UiState.Loading -> {
                SimpleCircularProgressComponent()
            }
            is UiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Text(
                        text = "Select your Style",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp
                    )
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
    }
}

@Composable
fun SimpleCircularProgressComponent() {
    // CircularProgressIndicator is generally used
    // at the loading screen and it indicates that
    // some progress is going on so please wait.
    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),

        // below line is used for specifying
        // vertical arrangement.
        verticalArrangement = Arrangement.Center,

        // below line is used for specifying
        // horizontal arrangement.
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        // below line is use to display
        // a circular progress bar.
        CircularProgressIndicator(
            // below line is use to add padding
            // to our progress bar.
            modifier = Modifier.padding(16.dp),

            // below line is use to add color
            // to our progress bar.
            color = Color.DarkGray,

            // below line is use to add stroke
            // width to our progress bar.
            strokeWidth = Dp(value = 4F)
        )
    }
}
