package com.example.udaan.screens.login

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager

data class LoginUiState(

    var emailValue: String = "",
    var passwordValue: String = "",
    var passwordVisibility: Boolean = false,
    val focusRequester: FocusRequester =  FocusRequester()
)