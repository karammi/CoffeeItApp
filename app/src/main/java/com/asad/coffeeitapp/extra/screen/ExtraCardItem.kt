package com.asad.coffeeitapp.extra.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.asad.coffeeitapp.R
import com.asad.coffeeitapp.domain.model.ExtraModel
import com.asad.coffeeitapp.domain.model.SubSelectionModel

@Composable
fun ExtraCardItem(
    extraItem: ExtraModel,
    list: List<SubSelectionModel> = emptyList(),
    onItemClicked: (ExtraModel, SubSelectionModel?) -> Unit,
    isClickedSubSelection: Boolean = false,
) {

    var showSubSelection by remember { mutableStateOf(isClickedSubSelection) }

    fun calculateCardHeight(): Dp {
        return if (showSubSelection)
            ((list.size * 78) + 90).dp
        else
            90.dp
    }

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .fillMaxSize()
            .shadow(2.dp, shape = RoundedCornerShape(12.dp))
            .background(Color(0xFFAED7A0))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(90.dp)
                .noRippleClickable {
                    showSubSelection = !showSubSelection
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
                text = extraItem.name,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
        }

        AnimatedVisibility(
            visible = showSubSelection,
            enter = expandVertically(expandFrom = Alignment.Top),
            exit = shrinkVertically(animationSpec = tween(500)),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)

            ) {
                Divider(color = Color.White, modifier = Modifier.padding(bottom = 8.dp))
                list.map { currentSubSelection ->
                    Row(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .shadow(2.dp, shape = RoundedCornerShape(12.dp))
                            .background(Color(0xFF9BC88B))
                            .fillMaxWidth()
                            .requiredHeight(60.dp)
                            .padding(horizontal = 16.dp)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = null,
                                onClick = {
                                    onItemClicked(extraItem, currentSubSelection)
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = currentSubSelection.name,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_radio_button_unchecked),
                            contentDescription = "radio",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}
