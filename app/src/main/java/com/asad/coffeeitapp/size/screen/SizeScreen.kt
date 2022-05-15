package com.asad.coffeeitapp.size.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.asad.coffeeitapp.core.ui.CoffeeCardItem
import com.asad.coffeeitapp.splash.screen.ConfigStatusBar

@Composable
fun SizeScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    SizeScreenContent(navController = navController, mainViewModel = mainViewModel)
}

@Composable
fun SizeScreenContent(navController: NavController, mainViewModel: MainViewModel) {
    val uiState = mainViewModel.uiState.collectAsState()

    ConfigStatusBar()

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
                        modifier = Modifier.clickable { navController.navigateUp() }
                    )
                    Text(
                        text = "Brew with Lex",
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
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Select your Size",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp
            )

            LazyColumn {
                uiState.value.sizeList?.size?.let { list ->
                    items(list) { index ->
                        CoffeeCardItem(
                            title = uiState.value.sizeList!![index].name,
                            item = uiState.value.sizeList!![index],
                            onItemClicked = { selectedSize ->
                                mainViewModel.setSelectedSize(selectedSize)
                                navController.navigate(Screen.ExtraScreen.route)
                            }
                        )
                    }
                }
            }
        }
    }
}
