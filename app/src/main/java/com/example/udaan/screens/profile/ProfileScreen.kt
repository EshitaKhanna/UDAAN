package com.example.udaan.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udaan.screens.settings.SettingsViewModel

@Composable
fun ProfileScreen(
    /*navController: NavController,*/
    profileViewModel: ProfileViewModel = viewModel()
){
    val profileUiState by profileViewModel.uiState.collectAsState()
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsPreview(){
    ProfileScreen(/*navController = rememberNavController()*/)
}