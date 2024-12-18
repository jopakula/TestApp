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
import com.example.testapp.ui.screens.bottom.TestScreen
import com.example.testapp.ui.screens.bottom.TrainingResultsScreen
import com.example.testapp.ui.screens.bottom.TrainingScreen
import com.example.testapp.ui.screens.bottom.TrainingTestScreen

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
                onIconBackClick = { navigationController.popBackStack() },
                navigationController = navigationController,
                )
        }
        composable(Screens.Test.screen) { backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("cardId")?.toIntOrNull()
            TestScreen(
                cardId = cardId,
                onIconBackClick = { navigationController.popBackStack() },
                navigationController = navigationController,
            )
        }

        composable(Screens.Training.screen) { TrainingScreen(navigationController = navigationController) }
        composable(Screens.TrainingTest.screen) { TrainingTestScreen(navigationController = navigationController) }
        composable(Screens.TrainingResult.screen) { backStackEntry ->
            val correctAnswersCount = backStackEntry.arguments?.getString("correctAnswersCount")?.toIntOrNull() ?: 0
            TrainingResultsScreen(
                navigationController = navigationController,
                correctAnswersCount = correctAnswersCount,
            )
        }

        composable(Screens.Settings.screen) { SettingsScreen(dataStoreManager =  dataStoreManager) }


        composable(Screens.Screen2.screen) { Screen2() }
    }

}