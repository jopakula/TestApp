package com.example.testapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.ui.screens.MainScreen
import com.example.testapp.ui.screens.OnboardingScreen
import com.example.testapp.ui.screens.SplashScreen

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
        composable(Screens.Onboarding.screen) { OnboardingScreen(navigationController = navigationController) }
    }

}