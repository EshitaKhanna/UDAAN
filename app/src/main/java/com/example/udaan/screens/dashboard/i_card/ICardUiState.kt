package com.example.udaan.screens.dashboard.i_card

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class ICardUiState(
    val db: FirebaseFirestore = Firebase.firestore,
    var rollNo: String ="",
    var name: String ="",
    var email: String ="",
    var phone: String ="",
)
