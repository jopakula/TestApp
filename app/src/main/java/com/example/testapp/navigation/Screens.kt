package com.example.testapp.navigation

sealed class Screens(
    val screen: String
) {
    data object Splash: Screens("splash")
    data object Onboarding1: Screens("onboarding1")
    data object Onboarding2: Screens("onboarding2")
    data object Home: Screens("home")
    data object Main: Screens("main")
    data object Screen2: Screens("screen2")
    data object Screen3: Screens("screen3")
    data object Settings: Screens("settings")
}