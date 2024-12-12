package com.example.testapp.ui.screens

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
import com.example.testapp.ui.ChangeNavigationBarColor
import com.example.testapp.uikit.bottomBar.MyBottomBar
import com.example.testapp.uikit.common.MyBlackColor

@Composable
fun MainScreen() {
    val navigationController = rememberNavController()
    val selectedTab = remember { mutableIntStateOf(0) }

    ChangeNavigationBarColor(color = MyBlackColor)

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        bottomBar = {

            MyBottomBar(
                selectedTab = selectedTab.intValue,
                onTabSelected = { index ->
                    selectedTab.intValue = index
                    when (index) {
                        0 -> navigationController.navigate(Screens.Screen1.screen) {
                            popUpTo(Screens.Screen1.screen) { inclusive = true }
                        }
                        1 -> navigationController.navigate(Screens.Screen2.screen) {
                            popUpTo(Screens.Screen2.screen) { inclusive = true }
                        }
                        2 -> navigationController.navigate(Screens.Screen3.screen) {
                            popUpTo(Screens.Screen3.screen) { inclusive = true }
                        }
                        3 -> navigationController.navigate(Screens.Screen4.screen) {
                            popUpTo(Screens.Screen4.screen) { inclusive = true }
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        BottomNavigation(
            navigationController = navigationController,
            startDestination = Screens.Screen1.screen,
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@Composable
@Preview
private fun MainScreenPreview(){
    MainScreen()
}

