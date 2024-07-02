package com.reactive.composelist.presentation.screens.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.reactive.composelist.data.model.Data

@Composable
fun ItemListScreen(viewModel : ItemViewModel, navController : NavHostController) {
    val items by viewModel.items.collectAsState()

    LazyColumn {
        items(items) { item ->
            ItemRow(item, navController)
        }
    }
}

@Composable
fun ItemRow(data : Data, navController : NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("item_detail/${data.id}")
            }
    ) {
        Image(
            painter = rememberImagePainter(data.imageUrl),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = data.description, style = MaterialTheme.typography.h6)
        }
    }
}