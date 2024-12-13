package com.example.testapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.ui.screens.start.MainScreen
import com.example.testapp.ui.screens.start.Onboarding1Screen
import com.example.testapp.ui.screens.start.Onboarding2Screen
import com.example.testapp.ui.screens.start.SplashScreen

@Composable
fun StartNavigation(
    navigationController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
){

    NavHost(
        navController = navigationController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screens.Main.screen) { MainScreen() }
        composable(Screens.Splash.screen) { SplashScreen(navigationController = navigationController) }
        composable(Screens.Onboarding1.screen) { Onboarding1Screen(navigationController = navigationController) }
        composable(Screens.Onboarding2.screen) { Onboarding2Screen(navigationController = navigationController) }
    }

}