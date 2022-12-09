package com.example.udaan.screens.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel(){

    //UI State
    private val _uiState = MutableStateFlow(LoginUiState())

    //Backing Property
    val uiState: StateFlow<LoginUiState> =  _uiState.asStateFlow()
}