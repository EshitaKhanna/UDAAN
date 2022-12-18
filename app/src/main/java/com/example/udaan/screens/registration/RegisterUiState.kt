package com.example.udaan.screens.registration


import androidx.compose.ui.focus.FocusRequester
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class RegisterUiState (
    //firebase database
    val database: FirebaseDatabase = Firebase.database,
    val myRef: DatabaseReference = database.getReference("User Info"),

    //fireStore
    val db: FirebaseFirestore = Firebase.firestore,

    var nameValue:String = "",
    var emailValue:String = "",
    var passwordValue:String = "",
    var confirmPasswordValue:String = "",
    var phoneValue:String = "",
    var passwordVisibility:Boolean = false,
    var confirmPasswordVisibility:Boolean = false,
    var focusRequester:FocusRequester = FocusRequester()
)