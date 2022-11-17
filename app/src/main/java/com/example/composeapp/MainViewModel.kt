package com.example.composeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.ui.screens.Destinations

/**
 * Used to communicate between screens.
 */
class MainViewModel : ViewModel() {

    /*if isLoggedIn currentScreen= Home else login screen*/

    var scope= viewModelScope

    private val _currentScreen = MutableLiveData<Destinations>(Destinations.DrawerDestinations.Home)
    val currentScreen: LiveData<Destinations> = _currentScreen

    fun setCurrentScreen(screen: Destinations) {
        _currentScreen.value = screen
    }

    private val _clickCount = MutableLiveData(0)
    val clickCount: LiveData<Int> = _clickCount

    fun updateClick(value: Int) {
        _clickCount.value = value
    }
}