package com.example.novci2.navigation

sealed class AppScreen(val route: String) {

    object Home : AppScreen("home")
    object Payment : AppScreen("payment")
}