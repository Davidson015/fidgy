package com.divad.fidgy

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splash_screen")
    object MainScreen : Routes("main_screen")
    object ModeScreen : Routes("mode_screen")
    object HandScreen : Routes("hand_screen")
    object GameScreen : Routes("game_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}