package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.testapp.data.DataStoreManager
import com.example.testapp.navigation.Screens
import com.example.testapp.navigation.StartNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()
            val dataStoreManager by lazy { DataStoreManager(applicationContext) }
            StartNavigation(
                navigationController = navigationController,
                startDestination = Screens.Splash.screen,
                dataStoreManager = dataStoreManager
            )
        }
    }
}

