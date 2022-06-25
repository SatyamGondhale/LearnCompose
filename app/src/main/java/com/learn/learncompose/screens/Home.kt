package com.learn.learncompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Home(navigateToScreenOne: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Home Screen", modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter).padding(vertical = 20.dp), textAlign = TextAlign.Center)
        Button(modifier = Modifier.padding(10.dp), onClick = {
            navigateToScreenOne()
        }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                , text = "Open Screen One",
                textAlign = TextAlign.Center
            )
        }
    }
}