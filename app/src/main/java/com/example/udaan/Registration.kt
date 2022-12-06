package com.example.udaan

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udaan.ui.theme.Screens


@Composable
fun RegisterScreen(
    navController: NavController
) {

    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        //contentAlignment = Layout.Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,

            ){
            Spacer(modifier = Modifier.padding(30.dp))
            /*Image(
                painterResource(id = R.drawable.login),
                contentDescription = "login",
                modifier = Modifier
                    .size(150.dp)
                    .padding(20.dp)
            )*/
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Text(
                text = "Welcome OnBoard!",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Name
                OutlinedTextInput(
                    label = "Name",
                    value =  nameValue.value,
                    onValueChange = { nameValue.value = it } ,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                //Email
                OutlinedTextInput(
                    label = "E-mail Address",
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Email
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down) }
                    )

                )
                Spacer(modifier = Modifier.padding(5.dp))
                //Phone Number
                OutlinedTextInput(
                    label = "Mobile Number",
                    value =  phoneValue.value,
                    onValueChange = { phoneValue.value = it } ,
                    keyboardOptions =  KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                //Password
                OutlinedTextInput(
                    label = "Password",
                    value =  passwordValue.value,
                    onValueChange = { passwordValue.value = it } ,
                    keyboardOptions =  KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                Spacer(modifier = Modifier.padding(5.dp))
                //Confirm Password
                OutlinedTextInput(
                    label = "Confirm Password",
                    value =  confirmPasswordValue.value,
                    onValueChange = { confirmPasswordValue.value = it } ,
                    keyboardOptions =  KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus()}
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Task_Button(
                    onClick = {
                        navController.navigate(Screens.DashboardScreen.route)
                    },
                    task = stringResource(id = R.string.sign_up),
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Row {
                    Text(text = "Already have an account? ", fontSize = 16.sp)
                    Text(
                        text = stringResource(id = R.string.login),
                        modifier = Modifier.clickable(
                            onClick = {
                                navController.navigate(Screens.LoginScreen.route)
                                }

                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.secondaryColor),
                    )
                }
            }
        }
    }
}


@Composable
fun Task_Buttons(
    onClick: () ->Unit,
    task: String,
    modifier: Modifier= Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primaryColor)),
        modifier = Modifier
            .width(130.dp)
    ) {
        Text(
            text = task,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun Outlined_TextInput(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    //trailingIcon: (@Composable() () -> Unit)? = null,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        placeholder = { Text(text = label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedLabelColor = colorResource(id = R.color.primaryColor),
            focusedLabelColor =  colorResource(id = R.color.primaryColor),
            cursorColor = colorResource(id = R.color.primaryColor)
        ),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        // trailingIcon = {}

    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview(){
    RegisterScreen(navController = rememberNavController())
}