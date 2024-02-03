package com.learn.learncompose.composables

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun BasicDialog() {
    BasicAlertDialog(onDismissRequest = {
        Log.i("BasicDialog", "oops. Not Enjoying")
    }, onConfirmation = { Log.i("BasicDialog", "Confirmed, Keep Learning") })
}

@Composable
fun BasicAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(Icons.Filled.Person, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Confirmation")
        },
        text = {
            Text(text = "Please confirm are you enjoying Material Design 3 in compose learning ?")
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Yes")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("No")
            }
        }
    )
}