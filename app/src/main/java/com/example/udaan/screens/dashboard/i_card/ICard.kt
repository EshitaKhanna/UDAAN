package com.example.udaan.screens.dashboard.i_card

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udaan.screens.registration.RegisterViewModel

@Composable
fun ICardScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel(),
    iCardViewModel: ICardViewModel = viewModel()
){
    val registerUiState by registerViewModel.uiState.collectAsState()
    val iCardUiState by iCardViewModel.uiState.collectAsState()

    Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
        ){
            Box{
                Column(){
                    iCardUiState.db.collection("Class List")
                        .whereEqualTo("E-Mail",registerUiState.emailValue)
                        .get()
                        .addOnSuccessListener {
                            for(document in it){
                                iCardUiState.rollNo = registerUiState.db.collection("Class List").document(document.id).toString()
                                iCardUiState.name = registerUiState.db.collection("Class List").document(document.get("Name") as String).toString()
                                iCardUiState.email = registerUiState.db.collection("Class List").document(document.get("E-Mail")as String).toString()
                                iCardUiState.phone = registerUiState.db.collection("Class List").document(document.get("Phone_Number")as String).toString()
                                }
                            }

                    Text(
                        text = "Name: {$iCardUiState.name}",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Left,
                        //fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Class: ",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Left,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Enrollment Number: {$iCardUiState.rollNo}",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Left,
                        //fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Mobile Number: {$iCardUiState.phone}",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Left,
                        //fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    MyQR()
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ICardPreview(){
    ICardScreen(navController = rememberNavController())
}