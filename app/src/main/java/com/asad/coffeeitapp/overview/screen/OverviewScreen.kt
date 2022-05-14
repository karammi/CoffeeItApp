package com.asad.coffeeitapp.overview.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asad.coffeeitapp.R
import com.asad.coffeeitapp.Screen
import com.asad.coffeeitapp.coffee.viewModel.MainViewModel

@Composable
fun OverviewScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    OverviewScreenContent(navController = navController, mainViewModel = mainViewModel)
}

@Composable
fun OverviewScreenContent(navController: NavController, mainViewModel: MainViewModel) {
    val uiState = mainViewModel.uiState.collectAsState()

    val extra by remember(uiState.value) {
        derivedStateOf { uiState.value.extraList }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(vertical = 32.dp, horizontal = 16.dp)
                    .shadow(2.dp, shape = RoundedCornerShape(12.dp))
                    .background(Color(0xFF9BC88B))
                    .fillMaxWidth()
                    .requiredHeight(80.dp)
                    .padding(horizontal = 16.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Brew your coffee",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    ) {
        Text(text = "Overview")

        Box(
            modifier = Modifier
                .padding(16.dp)
                .shadow(2.dp, shape = RoundedCornerShape(12.dp))
                .background(Color(0xFFAED7A0))

        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(90.dp)
                        .clickable {
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                    )
                ) {
                    Image(
                        painter = painterResource(id = com.asad.coffeeitapp.R.drawable.ic_cappuchino),
                        contentDescription = "coffee"
                    )
                    Text(
                        text = uiState.value.selectedStyle.value?.name ?: "",
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "Edit",
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.MainScreen.route)
                        }
                    )
                }

                Divider(color = Color.White)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(90.dp)
                        .clickable {
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                    )
                ) {
                    Image(
                        painter = painterResource(id = com.asad.coffeeitapp.R.drawable.ic_cappuchino),
                        contentDescription = "coffee"
                    )
                    Text(
                        text = uiState.value.selectedSize.value?.name ?: "",
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "Edit",
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.SizeScreen.route)
                        }
                    )
                }

                Divider(color = Color.White)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(90.dp)
                        .clickable {
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp,
                    )
                ) {
                    Image(
                        painter = painterResource(id = com.asad.coffeeitapp.R.drawable.ic_cappuchino),
                        contentDescription = "coffee"
                    )
                    Text(
                        text = uiState.value.selectedExtra.value?.name ?: "",
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "Edit",
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.ExtraScreen.route)
                        }
                    )
                }

                Divider(color = Color.White)

                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .shadow(1.dp, shape = RoundedCornerShape(8.dp))
                        .background(Color(0xFF9BC88B))
                        .fillMaxWidth()
                        .requiredHeight(60.dp)
                        .padding(horizontal = 16.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = uiState.value.selectedSubSelection.value?.name ?: "",
                        color = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_radio_button_checked),
                        contentDescription = "radio",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
