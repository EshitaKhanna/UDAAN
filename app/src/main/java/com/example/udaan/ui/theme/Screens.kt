package com.example.udaan.ui.theme

sealed class Screens (val route: String){


    object MainScreen: Screens("Main_Screen")
    object LoginScreen: Screens("Login_Screen")
    object RegistrationScreen: Screens("Registration")
    object DashboardScreen: Screens("Dashboard")
}