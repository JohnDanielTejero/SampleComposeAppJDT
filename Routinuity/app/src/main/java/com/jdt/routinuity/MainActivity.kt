package com.jdt.routinuity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
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
import androidx.navigation.compose.rememberNavController
import com.jdt.routinuity.components.Navigation
import com.jdt.routinuity.utils.AppwriteCon
import com.jdt.routinuity.ui.theme.RoutinuityTheme
import com.jdt.routinuity.views.AuthScreen
import com.jdt.routinuity.views.DashboardScreen
import com.jdt.routinuity.views.SplashScreen

import io.appwrite.services.Databases


class MainActivity : ComponentActivity() {

    private lateinit var databases : Databases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        databases = AppwriteCon.getInstance(this).getDatabases()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    BackHandler(enabled = true) {

    }

    RoutinuityTheme {
        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .fillMaxHeight()
        ){
//            Navigation()
            DashboardScreen(navController)
        }
    }
}

@Preview
@Composable
fun AppPreview(){
  App()
}