package com.learn.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.background))
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Elevated()
                Spacer(modifier = Modifier.height(25.dp))
                Filled()
                Spacer(modifier = Modifier.height(25.dp))
                Outlined()
                Spacer(modifier = Modifier.height(25.dp))
                Text()
                Spacer(modifier = Modifier.height(25.dp))
                FilledTonal()
            }

        }
    }
}

@Preview
@Composable
fun Elevated() {
    ElevatedButton(onClick = {
        // Action to Perform
    },
        content = {
            Text(text = "Elevated Button")
        })
}

@Preview
@Composable
fun Filled() {
    Button(onClick = {
        // Action to Perform
    },
        content = {
            Text(text = "Filled Button")
        })
}

@Preview
@Composable
fun Outlined() {
    OutlinedButton(onClick = {
        // Action to Perform
    },
        content = {
            Text(text = "Outlined Button")
        })
}

@Preview
@Composable
fun Text() {
    TextButton(onClick = {
        // Action to Perform
    },
        content = {
            Text(text = "Text Button")
        })
}

@Preview
@Composable
fun FilledTonal() {
    FilledTonalButton(onClick = {
        // Action to Perform
    },
        content = {
            Text(text = "Filled Tonal Button")
        })
}


@Preview
@Composable
fun CustomButton() {
    Button(onClick = {
        // Action to Perform
    }, colors = ButtonDefaults.buttonColors(
        containerColor = colorResource(id = R.color.button_color),
        contentColor = Color.Black,
        disabledContainerColor = colorResource(id = R.color.button_color),
        disabledContentColor = Color.Black
    ),
        shape = CutCornerShape(
            topStartPercent = 10,
            topEndPercent = 10,
            bottomEndPercent = 10,
            bottomStartPercent = 10
        ), // Can add RoundedCorner
        border = BorderStroke(width = 2.dp, color = Color.Blue),
        content = {
            Image(imageVector = Icons.Outlined.Info, contentDescription = "")
            Text(text = "Custom Button")
        })
}

