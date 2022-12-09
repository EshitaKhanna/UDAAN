package com.example.udaan.screens.registration

import androidx.lifecycle.ViewModel
import com.example.udaan.screens.login.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel: ViewModel() {
    //UI State
    private val _uiState = MutableStateFlow(RegisterUiState())

    //Backing Property
    val uiState: StateFlow<RegisterUiState> =  _uiState.asStateFlow()
}