package com.example.testapp.navigation

sealed class Screens(
    val screen: String
) {
    data object Main: Screens("main")
    data object Splash: Screens("splash")
    data object Onboarding: Screens("onboarding")
    data object Screen1: Screens("screen1")
    data object Screen2: Screens("screen2")
    data object Screen3: Screens("screen3")
    data object Screen4: Screens("screen4")
}