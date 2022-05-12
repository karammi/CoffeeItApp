package com.asad.coffeeitapp.coffee.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asad.coffeeitapp.R
import com.asad.coffeeitapp.Screen
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel
import com.asad.coffeeitapp.core.ui.CoffeeCardItem
import com.asad.coffeeitapp.domain.model.TypeModel

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

@Composable
fun CoffeeItem(typeModel: TypeModel, onItemClicked: (TypeModel) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .height(90.dp)
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFF9BC88B))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClicked(typeModel)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                16.dp,
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_cappuchino),
                contentDescription = "coffee"
            )
            Text(
                text = typeModel.name,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_radio_button_checked),
                contentDescription = "radio"
            )
        }
    }
}
