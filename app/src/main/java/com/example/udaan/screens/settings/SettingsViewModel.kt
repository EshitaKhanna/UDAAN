package com.example.udaan.screens.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel(){
    //UI State
    private val _uiState = MutableStateFlow(SettingsUiState())

    //Backing Property
    val uiState: StateFlow<SettingsUiState> =  _uiState.asStateFlow()
}