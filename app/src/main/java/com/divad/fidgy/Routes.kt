package com.divad.fidgy

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash_screen")
    object MainScreen : Routes("main_screen")
    object ModeScreen : Routes("mode_screen")
}