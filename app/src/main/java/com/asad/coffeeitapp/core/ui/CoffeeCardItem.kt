package com.asad.coffeeitapp.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.asad.coffeeitapp.extra.screen.noRippleClickable

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
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .height(90.dp)
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFAED7A0))
            .noRippleClickable {
                onItemClicked(item)
            },
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
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
