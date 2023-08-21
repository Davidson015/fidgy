package com.divad.fidgy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divad.fidgy.ui.theme.Blue
import com.divad.fidgy.ui.theme.Gray
import com.divad.fidgy.ui.theme.Orange500

// Components
@Composable
fun Navbar(modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Orange500)
            .padding(horizontal = 50.dp)
    ) {
        Icon(
            tint = Gray,
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier
                .size(56.dp)
        )
        Icon(
            tint = Blue,
            imageVector = Icons.Default.ThumbUp,
            contentDescription = null,
            modifier = Modifier
                .size(56.dp),
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                tint = Color.White,
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
            )
        }
    }
}

@Composable
fun Btn(
    modifier: Modifier,
    onClick: () -> Unit,
    bgColor: Color,
    text: String
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = bgColor, contentColor = Color.White),
        contentPadding = PaddingValues(vertical = 30.dp),
        modifier = modifier
            .fillMaxWidth(.30f)
    ) {
        Text(text = text, fontSize = 68.sp)
    }
}

@Composable
fun BackToHome(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = Blue,
        content = {
            Icon(Icons.Filled.Home, "")
        },
        elevation = FloatingActionButtonDefaults.elevation(8.dp)
    )
}