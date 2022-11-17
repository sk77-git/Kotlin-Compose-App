package com.example.composeapp.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapp.R
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.ui.screens.drawerDestinationsList


@Composable
fun AppBar(title: String, toolBarIcon: ImageVector, onToolBarIconPressed: () -> Unit) {
    TopAppBar(title = { Text(text = title) }, navigationIcon = {
        IconButton(onClick = { onToolBarIconPressed() }) {
            Icon(imageVector = toolBarIcon, contentDescription = "Open Drawer")
        }
    })
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column() {
        DrawerHeader()
        DrawerBody(onDestinationClicked = onDestinationClicked)

    }
}

@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .background(MaterialTheme.colors.primary)
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Card(
            modifier = Modifier.size(68.dp),
            shape = CircleShape,
            elevation = 2.dp
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = "User Name",
            style = TextStyle(color = MaterialTheme.colors.onPrimary, fontSize = 20.sp)
        )
        Text(
            text = "useremail@domain.com",
            style = TextStyle(color = MaterialTheme.colors.onPrimary.copy(alpha = 0.5f))
        )
    }
}

@Composable
fun DrawerBody(onDestinationClicked: (route: String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        drawerDestinationsList.forEach { screen ->
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .clickable {
                        onDestinationClicked(screen.route)
                    }
            )
        }
    }

}


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    screens: List<Destinations.TabDestinations>,
    navController: NavController
) {
    BottomNavigation(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = "") },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        //popUpTo = navController.graph.startDestination
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}