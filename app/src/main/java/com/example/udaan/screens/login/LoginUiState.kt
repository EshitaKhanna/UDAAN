package com.example.udaan.screens.login


import androidx.compose.ui.focus.FocusRequester

data class LoginUiState(

    val emailValue: String = "",
    val passwordValue: String = "",
    val passwordVisibility: Boolean = false,
    val focusRequester: FocusRequester =  FocusRequester()
)