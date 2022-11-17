package com.example.composeapp.ui.screens.bottombar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel
import kotlin.random.Random

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Destinations.TabDestinations.Favorite)
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Favorite.", style = MaterialTheme.typography.h4)
        ColorBox()
        HelloScreen()
        println("Favourite Screen Built")

    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    val color1 = remember {
        mutableStateOf(Color.Yellow)
    }
    val color2 = mutableStateOf(Color.Black)
    Box(modifier = modifier
        .fillMaxSize(0.2f)
        .background(color = color1.value)
        .clickable {
            color1.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
            color2.value = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        }
    )
    Box(modifier = modifier
        .fillMaxSize(0.2f)
        .background(color = color2.value)

    )


}


/* rememberSavable to retain state over configuration change */
/*stateless widget -> state hoisting */
@Composable
fun HelloScreen() {
    println("HelloScreen Built")
    var name = rememberSaveable { mutableStateOf("") }

    HelloContent(name = name.value, onNameChange = { name.value = it })
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}
