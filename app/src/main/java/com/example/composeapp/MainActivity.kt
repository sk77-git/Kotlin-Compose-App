package com.example.composeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.ui.screens.auth.ForgotPasswordScreen
import com.example.composeapp.ui.screens.auth.LoginScreen
import com.example.composeapp.ui.screens.auth.RegisterScreen
import com.example.composeapp.ui.screens.tabDestinationsList
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.widgets.AppBar
import com.example.composeapp.ui.widgets.BottomBar
import com.example.composeapp.ui.widgets.Drawer
import com.example.composeapp.ui.screens.bottombar.FavoriteScreen
import com.example.composeapp.ui.screens.bottombar.HomeScreen
import com.example.composeapp.ui.screens.bottombar.NotificationScreen
import com.example.composeapp.ui.screens.drawer.AccountScreen
import com.example.composeapp.ui.screens.drawer.SettingsScreen
import com.example.composeapp.ui.screens.other.HelpScreen
import com.example.composeapp.ui.screens.other.ResultScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                App()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    val viewModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentScreen by viewModel.currentScreen.observeAsState()


    var topBar: @Composable () -> Unit = {
        AppBar(
            title = currentScreen!!.title,
            toolBarIcon = Icons.Filled.Menu,
            onToolBarIconPressed = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        )
    }
    val drawer: @Composable () -> Unit = {
        Drawer(onDestinationClicked = { route ->
            scope.launch {
                scaffoldState.drawerState.close()
            }
            navController.navigate(route) {
                //popUpTo = navController.graph.startDestination
                popUpTo(Destinations.DrawerDestinations.Home.route)
                launchSingleTop = true
            }
        })
    }
    val bottomBar: @Composable () -> Unit = {
        if (currentScreen == Destinations.DrawerDestinations.Home || currentScreen is Destinations.TabDestinations) {
            BottomBar(
                navController = navController,
                screens = tabDestinationsList
            )
        }
    }

    //currentScreen is Destinations.TabDestinations || currentScreen !is Destinations.DrawerDestinations
    if (currentScreen !is Destinations.TabDestinations && currentScreen !is Destinations.DrawerDestinations) {
        topBar = {
            AppBar(
                title = currentScreen!!.title,
                toolBarIcon = Icons.Default.ArrowBack,
                onToolBarIconPressed = {
                    navController.popBackStack()
                }
            )
        }
    }

    Surface {
        Scaffold(
            topBar = { topBar() },
            bottomBar = { bottomBar() },
            drawerContent = { drawer() },
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            scaffoldState = scaffoldState,
        ) {
            NavHost(
                navController = navController,
                startDestination = Destinations.DrawerDestinations.Home.route
            ) {
                composable(Destinations.DrawerDestinations.Home.route) {
                    HomeScreen(viewModel = viewModel)
                }
                composable(route = Destinations.DrawerDestinations.Account.route) {
                    AccountScreen(viewModel = viewModel)
                }

                composable(Destinations.DrawerDestinations.Settings.route) {
                    SettingsScreen(viewModel = viewModel, navController = navController)
                }
                composable(Destinations.OtherDestinations.Help.route) {
                    HelpScreen(viewModel = viewModel)
                }
                composable(Destinations.OtherDestinations.Result.route) {
                    ResultScreen(viewModel = viewModel)
                }

                composable(Destinations.TabDestinations.Favorite.route) {
                    FavoriteScreen(viewModel = viewModel)
                }
                composable(Destinations.TabDestinations.Notification.route) {
                    NotificationScreen(viewModel = viewModel)
                }

                /*Auth*/
                composable(Destinations.AuthDestinations.Login.route) {
                    LoginScreen(viewModel = viewModel)
                }
                composable(Destinations.AuthDestinations.Register.route) {
                    RegisterScreen(viewModel = viewModel)
                }
                composable(Destinations.AuthDestinations.ForgotPassword.route) {
                    ForgotPasswordScreen(viewModel = viewModel)
                }
            }
        }
    }
}

