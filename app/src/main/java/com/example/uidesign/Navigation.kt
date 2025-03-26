package com.example.uidesign

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uidesign.Screens.Login
import com.example.uidesign.Screens.Screen1
import com.example.uidesign.Screens.Screen2
import com.example.uidesign.Screens.Screen3
import com.example.uidesign.Screens.SignUp


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "screen1",
    ) {
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
        composable("screen3") { Screen3(navController) }
        composable("SignUp") { SignUp(navController) }
        composable("Login") { Login(navController) }
    }
}