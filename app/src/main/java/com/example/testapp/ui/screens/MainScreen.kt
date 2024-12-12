package com.example.testapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.testapp.navigation.BottomNavigation
import com.example.testapp.navigation.Screens

@Composable
fun MainScreen() {
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.DateRange)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.LightGray
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.DateRange
                        navigationController.navigate(Screens.Screen1.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1F)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange, contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Icons.Default.DateRange) Color.Black else Color.DarkGray
                    )

                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Screen2.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1F)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.Black else Color.DarkGray
                    )

                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Menu
                        navigationController.navigate(Screens.Screen3.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1F)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu, contentDescription = null,
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == Icons.Default.Menu) Color.Black else Color.DarkGray
                    )
                }
            }
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
