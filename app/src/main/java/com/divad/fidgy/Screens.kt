package com.divad.fidgy

import android.app.Activity
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.divad.fidgy.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(controller: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

        // Set the screen delay duration
        delay(3000L)
        controller.navigate(Routes.MainScreen.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Green500),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Fidgy",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 80.sp,
            modifier = Modifier
                .alpha(scale.value)
                .scale(scale.value)
        )
    }
}

@Composable
fun MainScreen(controller: NavController) {

    // Handling the Back button pressed function for the screen
    val activity = LocalContext.current as? Activity
    BackHandler (
        enabled = true
    ) {
        activity?.finish()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Navbar(
            modifier = Modifier
                .align(Alignment.TopStart)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_hands_foreground),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(.80f)
            )
            
//            Spacer(modifier = Modifier.height(30.dp))

            Btn(
                onClick = {
                    controller.navigate(Routes.ModeScreen.route)
                },
                modifier = Modifier,
                bgColor = Blue,
                text = "Play"
            )
        }
    }
}

@Composable
fun ModeScreen(controller: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Navbar(
            modifier = Modifier
                .align(Alignment.TopStart)
        )

        Column {
            Btn(
                onClick = {
                    controller.navigate(Routes.ModeScreen.route)
                },
                modifier = Modifier,
                bgColor = Green500,
                text = "Easy"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Btn(
                onClick = {
                    controller.navigate(Routes.ModeScreen.route)
                },
                modifier = Modifier,
                bgColor = Blue,
                text = "Medium"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Btn(
                onClick = {
                    controller.navigate(Routes.ModeScreen.route)
                },
                modifier = Modifier,
                bgColor = Yellow,
                text = "Hard"
            )
        }

        Box(modifier = Modifier.align(Alignment.BottomStart).padding(start = 20.dp,  bottom = 20.dp)){
            BackToHome(onClick = {controller.navigate(Routes.MainScreen.route)})
        }
    }
}
