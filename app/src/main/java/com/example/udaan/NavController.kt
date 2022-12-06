package com.example.udaan

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.udaan.ui.theme.Screens

@Composable
fun setUpNavController(controller: NavHostController){
    NavHost(navController = controller, startDestination = Screens.MainScreen.route){
        composable(Screens.MainScreen.route){
            //show screen main
            MainScreen(navController = controller)
        }
        composable(Screens.LoginScreen.route){
            //show screen login
            LoginScreen(navController = controller)
        }
        composable(Screens.DashboardScreen.route){
            //show screen dashboard
            Dashboard()
        }

        composable(Screens.RegistrationScreen.route){
            //show screen registration
            RegisterScreen(navController = controller)
        }
    }
}