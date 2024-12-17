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
    data object Training: Screens("training")
    data object TrainingTest: Screens("training_test")
    data object TrainingResult: Screens("training_result/{correctAnswersCount}") {
        fun createRoute(correctAnswersCount: Int) = "training_result/$correctAnswersCount"
    }
    data object Settings: Screens("settings")
    data object Detail: Screens("detail/{cardId}"){
        fun createRoute(cardId: Int) = "detail/$cardId"
    }
    data object Test: Screens("test/{cardId}"){
        fun createRoute(cardId: Int) = "test/$cardId"
    }
}