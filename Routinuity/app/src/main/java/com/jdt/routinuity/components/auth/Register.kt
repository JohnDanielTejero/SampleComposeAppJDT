package com.jdt.routinuity.components.auth

import RoundedRightTriangle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jdt.routinuity.components.shapes.BlurredCircle

import com.jdt.routinuity.ui.theme.RoutinuityTheme



@Composable
fun RegisterScreen(onLoginClick: () -> Unit, navController: NavController) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .align(Alignment.TopStart)
                .offset((-20).dp, (-10).dp)
        ){
            BlurredCircle(blurColor = MaterialTheme.colorScheme.background)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .offset(0.dp, 50.dp)
        ){
            BlurredCircle(blurColor = MaterialTheme.colorScheme.background)
        }
        Column(
            modifier =  Modifier.offset(0.dp, (1).dp)
        ){
            Row(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
            ) {
                RoundedRightTriangle (
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    color = MaterialTheme.colorScheme.background,
                    cornerRadius = 5.dp,
                    direction =  TriangleDirection.Left
                ){
                    RoundedRightTriangle (
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(start = 4.dp, top = 8.dp),
                        color = MaterialTheme.colorScheme.primary,
                        cornerRadius = 5.dp,
                        direction =  TriangleDirection.Left,
                        onClick = onLoginClick,
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(start = 20.dp, bottom = 10.dp),
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.Start,
                        ){
                            Text("Login", color = MaterialTheme.colorScheme.background)
                        }
                    }
                }

                RoundedRightTriangle(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(110.dp),
                    color = MaterialTheme.colorScheme.background,
                    cornerRadius = 5.dp,
                    direction =  TriangleDirection.Right
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(4.dp, 0.dp, 4.dp, 4.dp),
            ) {
                Column ( verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.primary)
                        .padding(16.dp, 24.dp),
                ){
                    Text(
                        text = "REGISTER",
                        color = MaterialTheme.colorScheme.background,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(50.dp))

                    TextField(
                        value = username,
                        onValueChange = { value ->
                            username = value
                        },
                        label = { Text(text = "Username", color = MaterialTheme.colorScheme.background) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            cursorColor = MaterialTheme.colorScheme.background,
                            focusedTextColor =  MaterialTheme.colorScheme.background,
                            unfocusedTextColor = MaterialTheme.colorScheme.background,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = MaterialTheme.colorScheme.background,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
                        )
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = email,
                        onValueChange = { value ->
                            email = value
                        },
                        textStyle = TextStyle(color = MaterialTheme.colorScheme.background),
                        label = { Text(text = "Email", color = MaterialTheme.colorScheme.background) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            cursorColor = MaterialTheme.colorScheme.background,
                            focusedTextColor =  MaterialTheme.colorScheme.background,
                            unfocusedTextColor = MaterialTheme.colorScheme.background,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = MaterialTheme.colorScheme.background,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
                        )
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    TextField(
                        value = password,
                        onValueChange = { value ->
                            password = value
                        },
                        textStyle = TextStyle(color = MaterialTheme.colorScheme.background),
                        label = { Text(text = "Password", color = MaterialTheme.colorScheme.background) },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        colors = TextFieldDefaults.colors(
                            cursorColor = MaterialTheme.colorScheme.background,
                            focusedTextColor =  MaterialTheme.colorScheme.background,
                            unfocusedTextColor = MaterialTheme.colorScheme.background,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = MaterialTheme.colorScheme.background,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
                        )
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Button(
                        onClick
                        = {},
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(25f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = "Sign Up")
                    }
                }
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Align this triangle to the top left
                    RoundedRightTriangle(
                        color = MaterialTheme.colorScheme.background,
                        orientation = TriangleOrientation.UpsideDown,
                        modifier = Modifier
                            .width(110.dp)
                            .height(20.dp)
                            .align(Alignment.TopEnd),
                        cornerRadius = 0.dp
                    )

                }

            }
        }
    }
}

@Preview
@Composable
fun RegisterPreview(){
    val navController = rememberNavController()
    RoutinuityTheme {
        RegisterScreen({}, rememberNavController())
    }
}
