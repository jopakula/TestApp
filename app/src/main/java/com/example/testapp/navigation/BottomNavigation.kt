package com.example.testapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.ui.screens.Screen1
import com.example.testapp.ui.screens.Screen2
import com.example.testapp.ui.screens.Screen3

@Composable
fun BottomNavigation(
    navigationController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
){

    NavHost(
        navController = navigationController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screens.Screen1.screen) { Screen1() }
        composable(Screens.Screen2.screen) { Screen2() }
        composable(Screens.Screen3.screen) { Screen3() }
    }

}