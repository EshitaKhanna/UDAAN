package com.example.udaan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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


@Composable
fun Dashboard(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
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

        Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
            FunctionsCopy(onClick = {}, image = R.drawable.i_card, funct = "Generate/View I-Card")
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
fun FunctionsCopy(
    image: Int,
    funct: String,
    onClick: () -> Unit
){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(110.dp)
            .width(110.dp)
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = { onClick })
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
    Dashboard()
}