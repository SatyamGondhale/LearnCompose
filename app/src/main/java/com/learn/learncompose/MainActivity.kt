package com.learn.learncompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learn.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ColumnComposable("Learning Compose Column")
                }
            }
        }
    }
}

@Composable
fun RowComposable(name: String) {
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(
            text = "Hello $name!",
            textAlign = TextAlign.Center
        )
        Text(
            text = "Text One",
            textAlign = TextAlign.Center
        )
        Text(
            text = "Text two",
            textAlign = TextAlign.Center
        )
        Text(
            text = "Text  three",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ColumnComposable(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello $name!",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Columns arrange text Vertically",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "verticalArrangement controls vertical positioning of child elements",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "horizontalAlignment controls horizontal positioning of child elements",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ComposableBox() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        ) {
            Image(
                modifier = Modifier.align(Alignment.Center),
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Message"
            )
            Image(
                modifier = Modifier.align(Alignment.BottomEnd),
                painter = painterResource(id = R.drawable.ic_baseline_check_circle_outline_24),
                contentDescription = "Message"
            )
        }
    }
}

@Composable
fun ModifiersUsage() {
    Column(
        // Fill the content the whole available space on scree
        modifier = Modifier
            .fillMaxSize()
            // apply color to background
            .background(Color.LightGray)
    ) {
        Text(textAlign = TextAlign.Center, modifier = Modifier
            // Give specific width to UI element
            .size(width = 100.dp, height = 50.dp)
            // This is invoked when the UI element is clicked
            .clickable {
                Log.i("ON_CLICK", "I am Clicked")
            }
            // This controls common alignment of UI element
            .align(Alignment.CenterHorizontally)
            // This helps to give border to UI element
            .border(BorderStroke(width = 5.dp, Color.Red))
            // This helps adds some extra space along each edges of element
            .padding(2.dp), text = "Text Composable")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnComposeTheme {
         ColumnComposable(name = "Compose Column")
        // RowComposable("Compose Row")
        // ModifiersUsage()
        //ComposableBox()
    }
}