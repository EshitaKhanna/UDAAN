package com.example.udaan.firebase

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object FirebaseAuthRepo {
    fun login(
        firebaseAuth: FirebaseAuth,
        email: String,
        password: String,
        onSuccess: ()-> Unit,
        onFailure: (Exception?)-> Unit,
        )/*: StateFlow<Boolean?>*/ {

        val userAuthStatus = MutableStateFlow<Boolean?>(null)

        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    onSuccess()
                   // userAuthStatus.value = true
                }else{
                    onFailure(it.exception)
                  //  userAuthStatus.value = false
                }
            }
       // return userAuthStatus
    }

    fun signUp(firebaseAuth: FirebaseAuth,
               email: String,
               password: String,
               onSuccess: ()-> Unit,
               onFailure: (Exception?)-> Unit
    ){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                 onSuccess()
                }else{
                    onFailure(it.exception)
                }
            }
    }

}