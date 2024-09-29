package com.appsmindstudio.wedlock_profile.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.appsmindstudio.wedlock_profile.ui.navigation.AppNavigation
import com.appsmindstudio.wedlock_profile.ui.theme.MarryGestureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                MarryGestureTheme {
                    val navController = rememberNavController()
                    AppEntryPoint(navController)
                }
            }
        }
    }
}

@Composable
fun AppEntryPoint(navController: NavHostController) {
    AppNavigation(navController)
}