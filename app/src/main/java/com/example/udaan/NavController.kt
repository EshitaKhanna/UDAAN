package com.example.udaan

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.udaan.screens.dashboard.Dashboard
import com.example.udaan.screens.dashboard.i_card.ICardScreen
import com.example.udaan.screens.dashboard.students_list.ClassListCopy
import com.example.udaan.screens.dashboard.students_list.ClassListDB
import com.example.udaan.screens.login.LoginScreen
import com.example.udaan.screens.registration.RegisterScreen
import com.example.udaan.screens.registration.RegisterScreen2
import com.example.udaan.ui.theme.Screens

@Composable
fun SetUpNavController(controller: NavHostController) {
    NavHost(navController = controller, startDestination = Screens.MainScreen.route) {
        composable(Screens.MainScreen.route) {
            //show screen main
            MainScreen(navController = controller)
        }
        composable(Screens.LoginScreen.route) {
            //show screen login
            LoginScreen(navController = controller)
        }
        composable(Screens.DashboardScreen.route) {
            //show screen dashboard
            Dashboard(navController = controller)
        }
        composable(Screens.RegistrationScreen.route) {
            //show screen registration
            RegisterScreen(navController = controller)
        }
        composable(Screens.RegistrationScreen2.route) {
            //show screen registration - 2
            RegisterScreen2(navController = controller, options = listOf("Student", "Volunteer"))
        }
        composable(Screens.ICard.route) {
            //show screen registration
            ICardScreen(navController = controller)
        }
        composable(Screens.StudentList.route) {
            //show screen registration
            //ClassListCopy()
            ClassListDB()
        }
    }
}