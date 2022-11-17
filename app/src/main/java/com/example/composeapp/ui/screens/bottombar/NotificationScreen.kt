package com.example.composeapp.ui.screens.bottombar

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel
import kotlin.random.Random

@SuppressLint("UnrememberedMutableState")
@Composable
fun NotificationScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Destinations.TabDestinations.Notification)
    val color1 = remember {
        mutableStateOf(Color.Yellow)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Notification.", style = MaterialTheme.typography.h4)
        ColorBox2(color = color1) {
            color1.value = it
        }
    }
}

@Composable
fun ColorBox2(
    modifier: Modifier = Modifier,
    color: MutableState<Color>,
    updateColor: (Color) -> Unit
) {
    Box(modifier = modifier
        .fillMaxSize(0.2f)
        .background(color.value)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }
    )


}