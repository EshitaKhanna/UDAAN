package com.example.udaan.screens.registration

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusRequester

class RegisterUiState (

    var nameValue:String = "",
    var emailValue:String = "",
    var passwordValue:String = "",
    var confirmPasswordValue:String = "",
    var phoneValue:String = "",
    var passwordVisibility:Boolean = false,
    var confirmPasswordVisibility:Boolean = false,
    var focusRequester:FocusRequester = FocusRequester()
)