package com.example.udaan.screens.dashboard.students_list

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

data class StudentUiState(
    val database: FirebaseDatabase = Firebase.database,
    val myRef: DatabaseReference = database.getReference("User Info"),
    var check: Boolean = false,
    var result: String = ""
)
