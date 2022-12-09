package com.example.udaan.screens.profile

import androidx.lifecycle.ViewModel
import com.example.udaan.screens.settings.SettingsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel(){
    //UI State
    private val _uiState = MutableStateFlow(ProfileUiState())

    //Backing Property
    val uiState: StateFlow<ProfileUiState> =  _uiState.asStateFlow()
}