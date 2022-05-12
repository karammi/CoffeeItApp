package com.asad.coffeeitapp.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.asad.coffeeitapp.R

@Composable
fun <T> CoffeeCardItem(
    title: String,
    item: T,
    icon: Int? = null,
    onItemClicked: (T) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .height(90.dp)
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFAED7A0))
            .padding(16.dp)
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource(),
                onClick = {
                    onItemClicked(item)
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
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
                    text = title,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
