package com.example.udaan

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udaan.ui.theme.Screens
import com.example.udaan.ui.theme.UDAANTheme

@Composable
fun MainScreen(navController: NavController) {

    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.udaan_logo),
            contentDescription = "logo",
            modifier = Modifier
                .clickable(onClick = {
                    navController.navigate(Screens.LoginScreen.route)
                })
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    UDAANTheme {
        MainScreen(navController = rememberNavController())
    }
}