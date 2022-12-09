package com.example.udaan

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.udaan.ui.theme.Screens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun SetUpNavController(controller: NavHostController){
    NavHost(navController = controller, startDestination = Screens.MainScreen.route){
        composable(Screens.MainScreen.route){
            //show screen main
            MainScreen(navController = controller)
        }
        composable(Screens.LoginScreen.route){
            //show screen login
            LoginScreen(navController = controller, /*Firebase.auth*/)
        }
        composable(Screens.DashboardScreen.route){
            //show screen dashboard
            Dashboard(navController = controller)
        }

        composable(Screens.RegistrationScreen.route){
            //show screen registration
            RegisterScreen(navController = controller)
        }

        composable(Screens.RegistrationScreen2.route){
            //show screen registration2
            RegisterScreen2(navController = controller,options = listOf("Student", "Volunteer"))
        }
        composable(Screens.ICard.route){
            //show screen i-card
           ICardLayout()
        }
    }
}