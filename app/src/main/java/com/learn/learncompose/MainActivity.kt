package com.learn.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleText()
                Spacer(modifier = Modifier.height(15.dp)) // add Spacing
                TextFromResource()
                Spacer(modifier = Modifier.height(15.dp))
                TextWithColor()
                Spacer(modifier = Modifier.height(15.dp))
                TextWithSize()
                Spacer(modifier = Modifier.height(15.dp))
                TextWithStyle()
                Spacer(modifier = Modifier.height(15.dp))
                TextWithAlignment()
                Spacer(modifier = Modifier.height(15.dp))
                BasicTextField()
            }

        }
    }
}

@Preview
@Composable
fun SimpleText(){
    Text(text = "Learning Compose")
}

@Preview
@Composable
fun TextFromResource(){
    Text(text = stringResource(id = R.string.learn_compose))
}

@Preview
@Composable
fun TextWithColor(){
    Text(text = "Applying Colour to Text", color = Color.Red)
}

@Preview
@Composable
fun TextWithSize(){
    Text(text = "Applying Size to Text",fontSize = 25.sp)
}

@Preview
@Composable
fun TextWithStyle(){
    Text(text = "Applying Style to Text",fontStyle = FontStyle.Italic)
}

@Preview
@Composable
fun TextWithAlignment(){
    Text(text = "Applying Alignment to Text",textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun BasicTextField(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = { newValue -> text = newValue },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        label = { Text("label") },
        placeholder = { Text("placeholder") },
    )

}