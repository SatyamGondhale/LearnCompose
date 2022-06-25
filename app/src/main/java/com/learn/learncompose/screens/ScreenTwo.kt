package com.learn.learncompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ScreenTwo(getData: String?, navigateToScreenThree: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Text(
            text = "Screen Two",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(vertical = 20.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Woow, Data Received :: " + getData,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(vertical = 20.dp),
            textAlign = TextAlign.Center
        )
        Button(modifier = Modifier.padding(10.dp), onClick = {
            navigateToScreenThree()
        }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(), text = "Open Screen Three",
                textAlign = TextAlign.Center
            )
        }
    }
}