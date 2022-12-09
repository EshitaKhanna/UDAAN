package com.example.udaan.ui.theme

sealed class Screens (val route: String){

    object MainScreen: Screens("Main_Screen")
    object LoginScreen: Screens("Login_Screen")
    object RegistrationScreen: Screens("Registration")
    object RegistrationScreen2: Screens("Registration-2")
    object DashboardScreen: Screens("Dashboard")
    object ICard: Screens("I-Card")
    object ProfileScreen: Screens("Profile")
    object SettingsScreen: Screens("Settings")



}
