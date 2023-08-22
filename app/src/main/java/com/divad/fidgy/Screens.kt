package com.divad.fidgy

import android.app.Activity
import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.divad.fidgy.ui.theme.Blue
import com.divad.fidgy.ui.theme.Green500
import com.divad.fidgy.ui.theme.Yellow
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(controller: NavController) {
    val systemUiController: SystemUiController = rememberSystemUiController()
    DisposableEffect(key1 = true) {
        systemUiController.isNavigationBarVisible = false
        onDispose {
            systemUiController.isNavigationBarVisible = true
        }
    }



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
                modifier = Modifier
                    .offset(y = (-150).dp)
                    .fillMaxWidth(.25f),
                bgColor = Blue,
                text = "Play"
            )
        }
    }
}

@Composable
fun ModeScreen(controller: NavController) {
    var difficultyLevel by remember {
        mutableStateOf("")
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

        Column {
            Btn(
                onClick = {
                    difficultyLevel = "Easy"
                    controller.navigate(Routes.HandScreen.withArgs(difficultyLevel))
                },
                modifier = Modifier,
                bgColor = Green500,
                text = "Easy"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Btn(
                onClick = {
                    difficultyLevel = "Medium"
                    controller.navigate(Routes.HandScreen.withArgs(difficultyLevel))
                },
                modifier = Modifier,
                bgColor = Blue,
                text = "Medium"
            )

            Spacer(modifier = Modifier.height(30.dp))

            Btn(
                onClick = {
                    difficultyLevel = "Hard"
                    controller.navigate(Routes.HandScreen.withArgs(difficultyLevel))
                },
                modifier = Modifier,
                bgColor = Yellow,
                text = "Hard"
            )
        }

        BackToHome(onClick = {controller.navigate(Routes.MainScreen.route)}, modifier = Modifier.align(Alignment.BottomStart))
    }
}

@Composable
fun Handscreen(controller: NavController, difficulty: String) {
    var hand by remember {
        mutableStateOf("")
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

        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            IconButton(onClick = {
                hand = "lHand"
                controller.navigate(Routes.GameScreen.withArgs(difficulty, hand))
            }) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_lhand_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(.9f)
                        .width(600.dp)
                )
            }

            IconButton(onClick = {
                hand = "rHand"
                controller.navigate(Routes.GameScreen.withArgs(difficulty, hand))
            }) {
                Image(
                    painter = painterResource(id = R.mipmap.ic_rhand_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(.9f)
                        .width(600.dp)
                )
            }
        }

        BackToHome(onClick = {controller.navigate(Routes.MainScreen.route)}, modifier = Modifier.align(Alignment.BottomStart))
    }
}

@Composable
fun GameScreen(controller: NavController, difficulty: String, hand: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (hand == "lHand") {
            Text(text = "Left Hand chosen on $difficulty Difficulty.", fontSize = 60.sp)
        } else {
            Text(text = "Right Hand chosen on $difficulty Difficulty.", fontSize = 60.sp)
        }
    }
}
