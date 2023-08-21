package com.divad.fidgy

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Router() {
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    val controller = rememberNavController()
    
    NavHost(navController = controller, startDestination = Routes.SplashScreen.route) {

        // Adding screens to the NavHost
        composable(route = Routes.SplashScreen.route) {
            SplashScreen(controller = controller)
        }

        composable(route = Routes.MainScreen.route) {
            MainScreen(controller = controller)
        }

        composable(route = Routes.ModeScreen.route) {
            ModeScreen(controller = controller)
        }
    }
}