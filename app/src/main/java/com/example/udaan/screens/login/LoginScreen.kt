package com.example.udaan.screens.login

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udaan.R
import com.example.udaan.firebase.AuthViewModel
import com.example.udaan.firebase.UserLoginStatus
import com.example.udaan.ui.theme.Screens

@Composable
fun LoginScreen(
    navController: NavController,
    //loginViewModel: LoginViewModel = viewModel(),
    authViewModel: AuthViewModel = viewModel()
){
    //UdaanApp()

    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val isErrorInEmail by remember {
        derivedStateOf {
            if (emailValue.isEmpty()) { false }
            else{ Patterns.EMAIL_ADDRESS.matcher(emailValue).matches().not() }
        }
    }

    val focusRequester = FocusRequester.Default
    val focusManager = LocalFocusManager.current

  //  val loginUiState by loginViewModel.uiState.collectAsState()

    val loginStatus by authViewModel.userLoginStatus.collectAsState()

    var showFailedDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.padding(20.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp), contentAlignment = Alignment.BottomCenter
        ) {
            Spacer(modifier = Modifier.padding(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentAlignment = Alignment.TopCenter,

                ) {
                Spacer(modifier = Modifier.padding(100.dp))
                Image(
                    painterResource(id = R.drawable.login),
                    contentDescription = "login",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(20.dp)
                )
            }
            //Spacer(modifier = Modifier.padding(50.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                //.padding(top = 50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
/*                    DemoField(
                        value = emailValue,
                        onValueChange =  { emailValue = it } ,
                        label = "E-Mail Address",
                        placeholder = "E-Mail Address",
                        keyboardActions =  KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                           if(emailValue.isNotBlank()) { Icon(imageVector = Icons.Filled.Clear, contentDescription = null) }
                        },
                        isError = isErrorInEmail,
                        supportingText = "Enter a valid email address"
                    )*/
                    OutlinedTextField(
                        value = emailValue,
                        onValueChange =  { emailValue = it } ,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        label = { Text(text = "E-Mail Address") },
                        placeholder = { Text(text = "E-mail Address") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.primaryColor),
                            unfocusedBorderColor = colorResource(id = R.color.primaryColor),
                            unfocusedLabelColor = colorResource(id = R.color.primaryColor),
                            focusedLabelColor = colorResource(id = R.color.primaryColor),
                            cursorColor = colorResource(id = R.color.primaryColor)
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            if(emailValue.isNotBlank()) {
                                IconButton(onClick = {emailValue = ""}) {
                                    Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))

/*
                    DemoField(
                        value = passwordValue ,
                        onValueChange = {
                            passwordValue = it
                        },
                        label = "Password",
                        placeholder ="Password" ,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    imageVector = if(passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = null,
                                )
                            }
                        },
                        visualTransformation = if(passwordVisibility) { VisualTransformation.None  }
                                               else{ PasswordVisualTransformation() },
                        isError = false,
                        supportingText = "Invalid format"
                    )

 */
                    OutlinedTextField(
                        value = passwordValue,
                        onValueChange = { passwordValue = it },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Password
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.primaryColor),
                            unfocusedBorderColor = colorResource(id = R.color.primaryColor),
                            unfocusedLabelColor = colorResource(id = R.color.primaryColor),
                            focusedLabelColor = colorResource(id = R.color.primaryColor),
                            cursorColor = colorResource(id = R.color.primaryColor)
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Lock,
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    imageVector = if(passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = null,
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester = focusRequester)
                        )


                    Spacer(modifier = Modifier.padding(50.dp))
                    Task_Button(
                        onClick = {
                             when{
                                 emailValue.isBlank() ->{
                                     context.showToast("Enter your email!")
                                 }
                                passwordValue.isBlank() -> {
                                     context.showToast("Enter your password!")
                                 }
                                 else -> {
                                     authViewModel.performLogin(emailValue, passwordValue)
                                 }
                             }
                            navController.navigate(Screens.DashboardScreen.route)
                        },
                        task = stringResource(id = R.string.login),
                    )

                   /* when (loginStatus){
                        is UserLoginStatus.Failure -> {
                            //context.showToast("Unable to login")
                            Toast.makeText(context, "Unable to Login", Toast.LENGTH_SHORT).show()
                            showFailedDialog = true
                        }
                        UserLoginStatus.Successful -> {
                            //  context.showToast("Login successful")
                            navController.navigate(Screens.DashboardScreen.route)
                            //Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                        }
                        null -> { }
                    }

                    if(showFailedDialog){
                        // Alert Dialog
                        // Toast
                    }*/

                    Spacer(modifier = Modifier.padding(15.dp))
                    Row {
                        Text(text = "Don't have an account? ", fontSize = 16.sp)
                        Text(
                            text = stringResource(id = R.string.sign_up),
                            modifier = Modifier.clickable(
                                onClick = {
                                    navController.navigate(Screens.RegistrationScreen.route)
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
}


@Composable
fun Task_Button(
    onClick: () -> Unit,
    task: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primaryColor)),
        modifier = modifier
            .width(130.dp)
    ) {
        Text(
            text = task,
            color = Color.White,
            fontSize = 16.sp
        )
    }
}


/*
@OptIn(ExperimentalMaterial3Api::class)
@JvmOverloads
@Composable
fun DemoField(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean? = true,
    supportingText: String,
    isError: Boolean
){

    androidx.compose.material3.OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label =  BasicText(label) ,
        placeholder =  Text(placeholder),
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedBorderColor = colorResource(id = R.color.primaryColor),
            unfocusedLabelColor = colorResource(id = R.color.primaryColor),
            focusedLabelColor = colorResource(id = R.color.primaryColor),
            cursorColor = colorResource(id = R.color.primaryColor),
            textColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = singleLine,
        supportingText = { if (isError) Text(text = supportingText) },
        isError = isError
    )
}
*/

private fun Context.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}