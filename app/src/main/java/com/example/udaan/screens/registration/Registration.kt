package com.example.udaan.screens.registration
import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.udaan.firebase.RealTimeDatabase
import com.example.udaan.firebase.UserData
import com.example.udaan.ui.theme.Screens
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.Calendar
import java.util.Date

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel()
) {
    //UdaanApp()
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val registerUiState by registerViewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        //contentAlignment = Layout.Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
            ){
            Spacer(modifier = Modifier.padding(30.dp))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "Welcome OnBoard!",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                // Name
                OutlinedTextField(
                    value = registerUiState.nameValue,
                    onValueChange = { registerUiState.nameValue = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    label = { Text(text = "Name") },
                    placeholder = { Text(text = "Name") },
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
                            imageVector = Icons.Filled.Person,
                            contentDescription = null
                        )
                    },
                    trailingIcon = { }

                )
                Spacer(modifier = Modifier.padding(5.dp))
                //Email
                OutlinedTextField(
                    value = registerUiState.emailValue,
                    onValueChange = { registerUiState.emailValue = it },
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
                    trailingIcon = { }

                )
                Spacer(modifier = Modifier.padding(5.dp))
                //Phone Number
                OutlinedTextField(
                    value = registerUiState.phoneValue,
                    onValueChange = { registerUiState.phoneValue = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    label = { Text(text = "Phone Number") },
                    placeholder = { Text(text = "Phone Number") },
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
                            imageVector = Icons.Filled.Call,
                            contentDescription = null
                        )
                    },
                    trailingIcon = { }

                )
                Spacer(modifier = Modifier.padding(5.dp))
                //Password
                OutlinedTextField(
                    value = registerUiState.passwordValue,
                    onValueChange = { registerUiState.passwordValue = it },
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
                            registerUiState.passwordVisibility = !registerUiState.passwordVisibility
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null
                            )
                        }
                    },
                    visualTransformation = if (registerUiState.passwordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester = registerUiState.focusRequester),
                    )
                Spacer(modifier = Modifier.padding(5.dp))
                //Confirm Password
                OutlinedTextField(
                    value = registerUiState.confirmPasswordValue,
                    onValueChange = { registerUiState.confirmPasswordValue = it },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    label = { Text(text = "Confirm Password") },
                    placeholder = { Text(text = "Confirm Password") },
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
                            registerUiState.confirmPasswordVisibility =
                                !registerUiState.confirmPasswordVisibility
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.password_eye),
                                contentDescription = null,
                            )
                        }
                    },
                    visualTransformation = if (registerUiState.confirmPasswordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester = registerUiState.focusRequester),

                    )
                Spacer(modifier = Modifier.padding(20.dp))

                Button(
                    modifier = Modifier
                        .width(130.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.primaryColor)),

                    //the button is enabled when the user makes a selection
                    //enabled = selectedValue.isNotEmpty(),

                    onClick = {
                        if (registerUiState.nameValue.isNotEmpty() && registerUiState.emailValue.isNotEmpty()
                            && registerUiState.phoneValue.isNotEmpty() && registerUiState.passwordValue.isNotEmpty()
                            && registerUiState.confirmPasswordValue.isNotEmpty() &&
                            (registerUiState.passwordValue == registerUiState.confirmPasswordValue)
                        ) {
                            val students = hashMapOf(
                                "Name" to registerUiState.nameValue,
                                "E-Mail" to registerUiState.emailValue,
                                "Phone_Number" to registerUiState.phoneValue
                            )

                            registerUiState.db.collection("Class List")
                                .add(students)
                                .addOnSuccessListener { documentReference ->
                                    Toast.makeText(context,"Signed Up with ID: ${documentReference.id}", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(context,e.toString(), Toast.LENGTH_SHORT).show()
                                }
                            navController.navigate(Screens.RegistrationScreen2.route)
                        }else{
                            Toast.makeText(context,"Insert the value!", Toast.LENGTH_SHORT).show()
                        }

                    }
                ) {
                    Text(stringResource(id = R.string.next))
                }
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
fun RegisterScreen2(
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    navController: NavController
){
    //UdaanApp()
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = modifier.padding(16.dp)
    ){
        Spacer(modifier = Modifier.padding(30.dp))
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Date of Birth", fontSize = 18.sp)
            showDatePicker(LocalContext.current)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Divider(thickness = 1.dp, modifier = modifier.padding(bottom = 16.dp))

        Text(text =  "Pick a role", fontSize =  18.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        options.forEach { item ->
            Row (
                modifier = Modifier.selectable(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = selectedValue == item,
                    onClick = {
                        selectedValue = item
                        onSelectionChanged(item)
                    }
                )
                Text(item, fontSize =  16.sp)
            }
        }
        Divider(thickness = 1.dp, modifier = modifier.padding(bottom = 16.dp))
        Spacer(modifier = Modifier.padding(200.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(Screens.RegistrationScreen.route) })
            {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                enabled = selectedValue.isNotEmpty(),
                onClick = { navController.navigate(Screens.DashboardScreen.route) }
            ) {
                Text(stringResource(id = R.string.sign_up))
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
fun showDatePicker(context: Context){
    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }

    val datePickerDialog = remember{DatePickerDialog(
        context,
        {_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )}
    Spacer(modifier = Modifier.size(16.dp))
    //{TODO Increase the value of month by 1 and add this date picker to remember block}
    (Text(text = "   ${date.value}   "))
    Spacer(modifier = Modifier.size(16.dp))

    Image(painterResource(
        id = R.drawable.calendar),
        contentDescription = null,
        modifier = Modifier
            .clickable(onClick = { datePickerDialog.show() })
            .size(30.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview(){
    RegisterScreen2(navController = rememberNavController(), options = listOf("Student", "Volunteer"))
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview2(){
    RegisterScreen(navController = rememberNavController())
}



