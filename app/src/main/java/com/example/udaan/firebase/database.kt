package com.example.udaan.firebase

import androidx.compose.runtime.Composable
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun RealTimeDatabase(){

    val database = Firebase.database
    val myRef = database.getReference("User Info")


}


