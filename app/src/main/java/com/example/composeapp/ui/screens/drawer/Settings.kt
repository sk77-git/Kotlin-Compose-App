package com.example.composeapp.ui.screens.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel
import com.example.composeapp.R

@Composable
fun SettingsScreen(modifier: Modifier = Modifier, viewModel: MainViewModel, navController: NavController) {
    viewModel.setCurrentScreen(Destinations.DrawerDestinations.Settings)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SettingsScreen content here.")
        Button(onClick = { navController.navigate(Destinations.OtherDestinations.Help.route) }) {
            Text(text = "Go To Help")
        }
        SubcomposeAsyncImage(
            model = "https://www.freecodecamp.org/news/content/images/size/w2000/2022/06/helloWorld.png",
            contentDescription = stringResource(R.string.app_name)
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator()
            } else {
                SubcomposeAsyncImageContent()
            }
        }
        /*AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.freecodecamp.org/news/content/images/size/w2000/2022/06/helloWorld.png")
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = stringResource(R.string.app_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )*/
    }
}