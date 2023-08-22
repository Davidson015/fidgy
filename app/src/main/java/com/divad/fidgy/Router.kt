package com.divad.fidgy

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Router() {
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

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
        
        composable(
            route = Routes.HandScreen.route + "/{difficulty}",
            arguments = listOf(
                navArgument("difficulty") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            Handscreen(
                controller = controller,
                difficulty = entry.arguments!!.getString("difficulty")!!
            )
        }

        composable(
            route = Routes.GameScreen.route + "/{difficulty}/{hand}",
            arguments = listOf(
                navArgument("difficulty") {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument("hand") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            GameScreen(
                controller = controller,
                difficulty = entry.arguments!!.getString("difficulty")!!,
                hand = entry.arguments!!.getString("hand")!!
            )
        }
    }
}