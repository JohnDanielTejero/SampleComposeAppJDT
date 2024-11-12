package com.jdt.routinuity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jdt.routinuity.connection.AppwriteCon
import com.jdt.routinuity.ui.theme.RoutinuityTheme

import io.appwrite.services.Databases


class MainActivity : ComponentActivity() {

    lateinit var databases : Databases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        databases = AppwriteCon.getInstance(this).getDatabases()
        setContent {
            // Apply the theme to the entire screen

            RoutinuityTheme {
                Column (
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(all = 10.dp)
                ){
                    Greetings("android")
                }
            }
        }
    }
}

@Composable
fun Greetings(name: String) {
    Text(
        text = "$name",
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview
@Composable
fun GreetingPreivew(){
    RoutinuityTheme {
        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(all = 10.dp)
        ){
            Greetings("android")
        }
    }
}