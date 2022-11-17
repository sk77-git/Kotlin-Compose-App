package com.example.composeapp.ui.screens.other

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HelpScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Destinations.OtherDestinations.Help)
    val clickCount by viewModel.clickCount.observeAsState()
    var click = clickCount?: 0
    Scaffold( floatingActionButton = {
        FloatingActionButton(onClick = {
            click++
            viewModel.updateClick(click)
        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Press to increase counter"
            )
        }
    }) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "You have pushed the button many times")
            Text(text = "$click", style = MaterialTheme.typography.h4)
            /*Button(onClick = {
                navController.navigate(Destinations.DrawerDestinations.Home.route) {
                    popUpTo(Destinations.DrawerDestinations.Home.route) { inclusive = true }
                }
            }) {
                Text(text = "Go to home page")
            }
            Button(onClick = { navController.navigate(Destinations.OtherDestinations.Result.route) }) {
                Text(text = "Go to result page")
            }*/
        }
    }
}