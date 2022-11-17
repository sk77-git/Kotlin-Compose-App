package com.example.composeapp.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
sealed class Destinations(val title: String, val route: String, val icon: ImageVector) {
    sealed class DrawerDestinations(title: String, route: String, icon: ImageVector) :
        Destinations(title, route, icon) {
        object Home : DrawerDestinations("Home", "home", Icons.Default.Home)
        object Account : DrawerDestinations("Account", "account", Icons.Default.Person)
        object Settings : DrawerDestinations("Settings", "settings", Icons.Default.Settings)
    }

    sealed class TabDestinations(title: String, route: String, icon: ImageVector) :
        Destinations(title, route, icon) {
        object Home : TabDestinations("Home", "home", Icons.Default.Home)
        object Favorite : TabDestinations("Favorite", "favourite", Icons.Default.Favorite)
        object Notification : TabDestinations("Notification", "notification", Icons.Default.Notifications)
    }

    sealed class OtherDestinations(title: String, route: String, icon: ImageVector) :
        Destinations(title, route, icon) {
        object Help : OtherDestinations("Help", "help", Icons.Default.Call)
        object Result : OtherDestinations("Result", "result", Icons.Default.Check)
    }
    sealed class AuthDestinations(title: String, route: String, icon: ImageVector) :
        Destinations(title, route, icon) {
        object Login : OtherDestinations("Login", "login", Icons.Default.Call)
        object Register : OtherDestinations("Register", "register", Icons.Default.Check)
        object ForgotPassword : OtherDestinations("Forgot Password", "forgot_password", Icons.Default.Check)
    }



    /*object Home : Destinations("Home", "home", Icons.Default.Home)
    object Account : Destinations("Account", "account", Icons.Default.Person)
    object Settings : Destinations("Settings", "settings", Icons.Default.Settings)
    object Help : Destinations("Help", "help", Icons.Default.Call)
    object Result : Destinations("Result", "result", Icons.Default.Check)*/
}

val drawerDestinationsList = listOf(
    //for showing nav menu list
    Destinations.DrawerDestinations.Home,
    Destinations.DrawerDestinations.Account,
    Destinations.DrawerDestinations.Settings,
)
val tabDestinationsList = listOf(
    Destinations.TabDestinations.Home,
    Destinations.TabDestinations.Favorite,
    Destinations.TabDestinations.Notification,
)

val authDestinationsList= listOf(
    Destinations.AuthDestinations.Login,
    Destinations.AuthDestinations.Register,
    Destinations.AuthDestinations.ForgotPassword,
)















