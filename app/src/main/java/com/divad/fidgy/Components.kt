package com.divad.fidgy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.divad.fidgy.ui.theme.Blue
import com.divad.fidgy.ui.theme.Gray
import com.divad.fidgy.ui.theme.Orange500

// Components
@Composable
fun Navbar(modifier: Modifier) {
    var streak by remember {
        mutableStateOf(0)
    }

    var completedLessons by remember {
        mutableStateOf(0)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Orange500)
            .padding(horizontal = 50.dp)
            .padding(top = 15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = Gray,
                painter = painterResource(id = R.drawable.ic_streak),
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "$streak", color = Gray, fontSize = 56.sp, fontWeight = FontWeight.Bold)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                tint = Blue,
                imageVector = Icons.Default.ThumbUp,
                contentDescription = null,
                modifier = Modifier
                    .size(56.dp),
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "$completedLessons", color = Color.White, fontSize = 56.sp, fontWeight = FontWeight.Bold)
        }

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
            .fillMaxWidth(.30f),
        shape = RoundedCornerShape(35.dp),
        elevation = ButtonDefaults.elevation(10.dp)
    ) {
        Text(text = text, fontSize = 68.sp)
    }
}

@Composable
fun BackToHome(
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box(modifier = modifier.padding(start = 80.dp,  bottom = 80.dp)){
        FloatingActionButton(
            onClick = onClick,
            backgroundColor = Blue,
            content = {
                Icon(Icons.Filled.Home, "", modifier = Modifier.size(68.dp), tint = Color.White)
            },
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            modifier = Modifier.size(120.dp)
        )
    }

}