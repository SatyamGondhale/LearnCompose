package com.learn.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.learn.learncompose.composables.AllChipsExamples
import com.learn.learncompose.composables.BasicCards
import com.learn.learncompose.composables.BasicDialog
import com.learn.learncompose.composables.BasicIndicators
import com.learn.learncompose.composables.BasicSlider
import com.learn.learncompose.composables.BasicSnackbar
import com.learn.learncompose.composables.BasicSwitch
import com.learn.learncompose.composables.BottomAppBarExample
import com.learn.learncompose.composables.SmallTopAppBarExample
import com.learn.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                 SmallTopAppBarExample()
                // SmallTopAppBarExample()
                // CenterAlignedTopAppBarExample()
                // BottomAppBarExample()
                // BasicSwitch()
                // BasicSlider()
                // AllChipsExamples()
                // BasicCards()
                // BasicDialog()
                // BasicIndicators()
                // BasicSnackbar()
                // BasicSnackbar()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnComposeTheme {
        SmallTopAppBarExample()
        // SmallTopAppBarExample()
        // CenterAlignedTopAppBarExample()
        // BottomAppBarExample()
        // BasicSwitch()
        // BasicSlider()
        // AllChipsExamples()
    }
}