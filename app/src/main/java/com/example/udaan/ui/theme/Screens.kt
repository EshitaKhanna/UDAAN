package com.example.udaan.ui.theme

sealed class Screens (val route: String){


    object MainScreen: Screens("Main_Screen")
    object LoginScreen: Screens("Login_Screen")
    object RegistrationScreen: Screens("Registration")
    object RegistrationScreen2: Screens("Register-2")
    object DashboardScreen: Screens("Dashboard")
    object SettingsScreen: Screens("Settings")
    object ProfileScreen: Screens("User Profile")
    object ICard: Screens("I-Card")
    object StudentList: Screens("Class List")



}