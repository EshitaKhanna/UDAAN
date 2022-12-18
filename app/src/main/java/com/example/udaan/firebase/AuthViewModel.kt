package com.example.udaan.firebase

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel() {

    private val _userLoginStatus = MutableStateFlow<UserLoginStatus?>(null)
    val userLoginStatus = _userLoginStatus.asStateFlow()

    private val firebaseAuth = FirebaseAuth.getInstance()

/*
    init{
        createAccount("eshita.khanna97@gmail.com", "123456789")
    }
*/

    fun performLogin(email: String, password: String){
        FirebaseAuthRepo.login(
            firebaseAuth, email, password,
            onSuccess = {_userLoginStatus.value = UserLoginStatus.Successful },
            onFailure = {_userLoginStatus.value = UserLoginStatus.Failure(it) }
        )
    }

    fun createAccount(email: String, password: String){
        FirebaseAuthRepo.signUp(
            firebaseAuth, email, password,
            onSuccess = {_userLoginStatus.value = UserLoginStatus.Successful},
            onFailure = { _userLoginStatus.value = UserLoginStatus.Failure(it)}
        )

    }
}
sealed class UserLoginStatus{
    object Successful: UserLoginStatus()
    class Failure (val exception: Exception?): UserLoginStatus()
}