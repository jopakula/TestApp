package com.example.testapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.data.DataStoreManager
import com.example.testapp.ui.screens.bottom.DetailsScreen
import com.example.testapp.ui.screens.bottom.MainScreen
import com.example.testapp.ui.screens.bottom.Screen2
import com.example.testapp.ui.screens.bottom.SettingsScreen
import com.example.testapp.ui.screens.bottom.TrainingScreen

@Composable
fun BottomNavigation(
    navigationController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    dataStoreManager: DataStoreManager,
) {

    NavHost(
        navController = navigationController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screens.Main.screen) { MainScreen(
            navigationController = navigationController,
            dataStoreManager = dataStoreManager) }
        composable(Screens.Detail.screen) { backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("cardId")?.toIntOrNull()
            DetailsScreen(
                cardId = cardId,
                onIconBackClick = { navigationController.popBackStack() })
        }

        composable(Screens.Screen2.screen) { Screen2() }
        composable(Screens.Training.screen) { TrainingScreen() }
        composable(Screens.Settings.screen) { SettingsScreen() }
    }

}