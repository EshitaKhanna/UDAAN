@file:OptIn(ExperimentalMaterialApi::class)

package com.example.udaan.screens.dashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.udaan.R
//import com.example.udaan.screens.dashboard.students_list.getStudentList
import com.example.udaan.ui.theme.Screens

@Composable
fun Dashboard( navController: NavController){
    var check by remember { mutableStateOf<Boolean>(false) }
    var result by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box (
            modifier = Modifier
                .height(260.dp)
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(color = colorResource(id = R.color.primaryColor))
            ) {
                Spacer(modifier = Modifier.height(110.dp))
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User Profile Picture",
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .wrapContentWidth(align = Alignment.CenterHorizontally),

                    )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Volunteer Name",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

/*        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            FunctionsCopy(
                onClick = {navController.navigate(Screens.ICard.route)},
                image = R.drawable.i_card,
                funct = "Generate/View I-Card")
            FunctionsCopy(onClick = {},image = R.drawable.attendance, funct = "Attendance")
            FunctionsCopy(onClick = {},image = R.drawable.feedback, funct = "Feedback")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            FunctionsCopy(onClick = {},image = R.drawable.donate, funct = "Donate")
            FunctionsCopy(onClick = {},image = R.drawable.payment, funct = "Payment")
            FunctionsCopy(onClick = {},image = R.drawable.chat, funct = "Chat With Student")
        }
        Row() {
            FunctionsCopy(onClick = {},image = R.drawable.report, funct = "Class Report")
            FunctionsCopy(onClick = {},image = R.drawable.list, funct = "Class List")

        }*/

        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Button(
                onClick = { navController.navigate(Screens.ICard.route) },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.i_card),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "I-Card",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.Attendance.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.attendance),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Attendance",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.StudentList.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Feedback",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Button(
                onClick = { /*navController.navigate(Screens.ICard.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.donate),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Donate",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.Attendance.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.payment),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Payment",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.StudentList.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Chat With Student",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Button(
                onClick = { /*navController.navigate(Screens.ICard.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.report),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Class Report",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { navController.navigate(Screens.StudentList.route)},
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.list),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Class List",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.StudentList.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Feedback",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Button(
                onClick = { /*navController.navigate(Screens.ICard.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.report),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Class Report",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { navController.navigate(Screens.StudentList.route)},
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.list),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Class List",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.StudentList.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Feedback",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            Button(
                onClick = { /*navController.navigate(Screens.ICard.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.report),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Class Report",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { navController.navigate(Screens.StudentList.route)},
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.list),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Class List",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }

            Button(
                onClick = { /*navController.navigate(Screens.StudentList.route)*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .height(115.dp)
                    .width(115.dp)
                    .background(MaterialTheme.colors.surface),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface)
            ) {
                Box(contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(id = R.drawable.feedback),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .height(70.dp)
                            .width(70.dp)
                            .align(Alignment.TopCenter),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Feedback",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(top = 80.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun TaskButton(
    //TaskButton(onClick =  onPrevButtonClick , task = "Previous")
    onClick: () ->Unit,
    task: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        //colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_500)),
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FunctionsCopy(
    image: Int,
    funct: String,
    onClick: () -> Unit = {}
){
    Card(
        onClick = {onClick},
        modifier = Modifier
            .padding(8.dp)
            .height(110.dp)
            .width(110.dp)
            .background(MaterialTheme.colors.surface)
            //.clickable(onClick = { onClick })
    ) {
        Box ( modifier = Modifier.background(colorResource(id = R.color.surfaceColor))){
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .height(70.dp)
                    .width(70.dp)
                    .align(Alignment.TopCenter)
                //.clickable(onClick = { onClick })
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = funct,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                fontSize = 13.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .padding(5.dp)

            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview(){
    Dashboard(navController = rememberNavController())
}

