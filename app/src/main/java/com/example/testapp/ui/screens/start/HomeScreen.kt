package com.example.testapp.ui.screens.start

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.testapp.navigation.BottomNavigation
import com.example.testapp.navigation.Screens
import com.example.testapp.ui.helpfulFunctions.ChangeNavigationBarColor
import com.example.testapp.uikit.bottomBar.MyBottomBar
import com.example.testapp.uikit.common.BlackColor

@Composable
fun HomeScreen() {
    val navigationController = rememberNavController()
    val selectedTab = remember { mutableIntStateOf(0) }

    ChangeNavigationBarColor(color = BlackColor)

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        bottomBar = {

            MyBottomBar(
                selectedTab = selectedTab.intValue,
                onTabSelected = { index ->
                    selectedTab.intValue = index
                    when (index) {
                        0 -> navigationController.navigate(Screens.Main.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                        1 -> navigationController.navigate(Screens.Screen2.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                        2 -> navigationController.navigate(Screens.Training.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                        3 -> navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        BottomNavigation(
            navigationController = navigationController,
            startDestination = Screens.Main.screen,
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@Composable
@Preview
private fun MainScreenPreview(){
    HomeScreen()
}

