package com.asad.coffeeitapp.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.asad.coffeeitapp.domain.model.SubSelectionModel

@Composable
fun ExtraContent(nestedList: List<SubSelectionModel>, onItemSelected: (SubSelectionModel) -> Unit) {
    LazyColumn(Modifier.fillMaxWidth()) {
        items(nestedList.size) { index ->
            ExtraItemCard(item = nestedList[index]) { selectedExtra ->
                onItemSelected(selectedExtra)
            }
        }
    }
}

@Composable
fun ExtraItemCard(item: SubSelectionModel, onItemClicked: (SubSelectionModel) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .height(60.dp)
            .shadow(2.dp, shape = RoundedCornerShape(8.dp))
            .background(Color(0xFF9BC88B))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClicked(item)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                16.dp,
            )
        ) {

            Text(
                text = item.name,
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
