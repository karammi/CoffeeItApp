package com.asad.coffeeitapp.overview.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.asad.coffeeitapp.core.ui.ConfigStatusBar
import com.asad.coffeeitapp.extra.screen.noRippleClickable

@Composable
fun OverviewScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()) {
    OverviewScreenContent(navController = navController, mainViewModel = mainViewModel)
}

@Composable
fun OverviewScreenContent(navController: NavController, mainViewModel: MainViewModel) {
    val uiState = mainViewModel.uiState.collectAsState()

    ConfigStatusBar()

/*    val extra by remember(uiState.value) {
        derivedStateOf { uiState.value.extraList }
    }*/

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
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(vertical = 32.dp, horizontal = 16.dp)
                    .shadow(2.dp, shape = RoundedCornerShape(12.dp))
                    .background(Color(0xFF9BC88B))
                    .fillMaxWidth()
                    .requiredHeight(70.dp)
                    .padding(horizontal = 16.dp)
                    .noRippleClickable {
                    },
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
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Overview",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp
            )
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(2.dp, shape = RoundedCornerShape(12.dp))
                    .background(Color(0xFFAED7A0))

            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
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
                            painter = painterResource(id = R.drawable.ic_cappuchino),
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
                            modifier = Modifier.noRippleClickable {
                                navController.popBackStack(route = Screen.MainScreen.route, false)
                            }
                        )
                    }

                    Divider(color = Color.White)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(90.dp)
                            .noRippleClickable {
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
                            text = uiState.value.selectedSize.value?.name ?: "",
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "Edit",
                            color = Color.White,
                            modifier = Modifier.noRippleClickable {
                                navController.popBackStack(Screen.SizeScreen.route, false)
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
                            painter = painterResource(id = R.drawable.ic_cappuchino),
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
                            modifier = Modifier.noRippleClickable {
                                navController.popBackStack(Screen.ExtraScreen.route, false)
                            }
                        )
                    }

                    Divider(color = Color.White, modifier = Modifier.padding(bottom = 8.dp))

                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .shadow(1.dp, shape = RoundedCornerShape(8.dp))
                            .background(Color(0xFF9BC88B))
                            .fillMaxWidth()
                            .requiredHeight(60.dp)
                            .padding(horizontal = 16.dp)
                            .noRippleClickable { },
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
}
