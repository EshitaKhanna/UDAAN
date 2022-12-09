package com.example.udaan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.example.udaan.ui.theme.Screens
import com.example.udaan.ui.theme.UDAANTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        setContent {
            UDAANTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UdaanApp()
                    SetUpNavController(rememberNavController())

                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UdaanApp(){
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController = rememberNavController())
        }
    ){contentPadding ->
        // Screen content
        Box(modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize()) { /* ... */ }

    }
}

@Composable
private fun BottomBar(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(R.color.primaryColor)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        IconButton(
            onClick = { navController.navigate(Screens.DashboardScreen.route) },
            modifier = Modifier.padding(end = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Menu",
                tint = MaterialTheme.colors.onPrimary
            )
        }
        IconButton(
            onClick = { navController.navigate(Screens.ProfileScreen.route) },
            modifier = Modifier.padding(end = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Profile",
                tint = MaterialTheme.colors.onPrimary
            )
        }

        IconButton(
            onClick = { navController.navigate(Screens.SettingsScreen.route) },
            modifier = Modifier.padding(end = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Settings",
                tint = MaterialTheme.colors.onPrimary
            )
        }

    }

}


@Composable
private fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(colorResource(R.color.primaryColor)),

        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {  },
            modifier = Modifier.padding(end = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = MaterialTheme.colors.onPrimary
            )
        }
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(start = 2.dp),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
        )

    }
}