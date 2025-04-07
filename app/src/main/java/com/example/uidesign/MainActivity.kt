package com.example.uidesign

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Navigation(navController = navController)
        }
    }
}


//create and store the FCM token
//fun FCMTokens(){
//    FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
//        if (task.isSuccessful) {
//            val token = task.result
//            storeTokenInFirestore(userId, token)
//        } else {
//            Log.e("FCM", "Failed to fetch token", task.exception)
//        }
//    }
//}


