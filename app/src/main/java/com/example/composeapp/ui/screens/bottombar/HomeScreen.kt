package com.example.composeapp.ui.screens.bottombar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Destinations.DrawerDestinations.Home)
    val countryList =
        mutableListOf("India", "Pakistan", "China", "United States")


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home.", style = MaterialTheme.typography.h4)
        LazyColumn(Modifier.weight(1f)) {
            items(countryList) { item ->
                Text("$item", Modifier.fillMaxWidth().padding(8.dp))
            }
        }
    }
}

