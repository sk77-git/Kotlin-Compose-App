package com.example.composeapp.ui.screens.other

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel

@Composable
fun ResultScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Destinations.OtherDestinations.Result)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You had pushed the button many times in previous screen")
        Text(text = "", style = MaterialTheme.typography.h4)
        /*Button(onClick = {
            navController.navigate(Destinations.DrawerDestinations.Home.route) {
                popUpTo(Destinations.DrawerDestinations.Home.route) { inclusive = true }
            }
        }) {
            Text(text = "Go to home page")
        }*/
    }
}