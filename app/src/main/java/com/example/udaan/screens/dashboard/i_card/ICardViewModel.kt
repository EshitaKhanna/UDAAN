package com.example.udaan.screens.dashboard.i_card

import androidx.lifecycle.ViewModel
import com.example.udaan.screens.registration.RegisterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ICardViewModel: ViewModel() {
    //UI State
    private val _uiState = MutableStateFlow(ICardUiState())

    //Backing Property
    val uiState: StateFlow<ICardUiState> =  _uiState.asStateFlow()
}