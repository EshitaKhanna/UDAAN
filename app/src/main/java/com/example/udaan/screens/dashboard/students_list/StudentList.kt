package com.example.udaan.screens.dashboard.students_list

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


@Preview
@Composable
fun ListPrev(){
    ClassListCopy()
}

@Composable
fun ClassListCopy(){
    val context = LocalContext.current
    val database = Firebase.database
    val myRef = database.getReference("User Info")

    var check by remember { mutableStateOf<Boolean>(false) }
    var result by remember { mutableStateOf("")}

    Column(){

        var data = StringBuffer()
        //var data = List<String>()
        myRef.get().addOnSuccessListener {
            if (it.exists())
            {
                it.children.forEach() { it ->
                    data.append("\nName: " + it.child("name").value)
                    data.append("\nE-mail: " + it.child("email").value)
                    data.append("\nPhone Number: " + it.child("phone_number").value)
                    data.append("\n")
                }
                check = true
                result = data.toString()
            }
        }.addOnFailureListener {
            Toast.makeText(context, "Record not found", Toast.LENGTH_SHORT).show()
        }

        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = check, Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ){
                //Spacer(modifier = Modifier.padding(30.dp))
                Text(text = result, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun ClassList(){
    val context = LocalContext.current
    val database = Firebase.database
    val myRef = database.getReference("User Info")

    var check by remember { mutableStateOf<Boolean>(false) }
    var result by remember { mutableStateOf("")}

    Column(){
        OutlinedButton(
            modifier = Modifier
                .width(130.dp)
                .padding(20.dp),
            onClick = {
               var data = StringBuffer()
                //var data = List<String>()
                myRef.get().addOnSuccessListener {
                    if (it.exists())
                    {
                        it.children.forEach() { it ->
                            data.append("\nName: " + it.child("name").value)
                            data.append("\nE-mail: " + it.child("email").value)
                            data.append("\nPhone Number: " + it.child("phone_number").value)
                            data.append("\n")
                        }
                        check = true
                        result = data.toString()
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Record not found", Toast.LENGTH_SHORT).show()
                }
            }) {
            Text(text = "Class List")
        }
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = check, Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ){
                Spacer(modifier = Modifier.padding(30.dp))
                Text(text = result, fontSize = 14.sp)
            }
        }
    }
}
