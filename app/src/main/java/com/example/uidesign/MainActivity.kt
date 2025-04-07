package com.example.uidesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.compose.rememberNavController


// Create a CompositionLocal to provide FirebaseAnalytics inside Composables
val LocalAnalytics = staticCompositionLocalOf<FirebaseAnalytics> {
    error("No FirebaseAnalytics provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Analytics
        val firebaseAnalytics = Firebase.analytics
        // App opened
        // Log the app open event
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, null)

        setContent {
            val navController = rememberNavController()

            // Provide FirebaseAnalytics to the whole app
            CompositionLocalProvider(LocalAnalytics provides firebaseAnalytics) {
                Navigation(navController = navController)
            }
        }
    }
}
