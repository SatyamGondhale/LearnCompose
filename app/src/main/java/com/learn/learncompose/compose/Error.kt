package com.learn.learncompose.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.learn.learncompose.R
import com.learn.learncompose.ui.theme.Shapes

@Preview
@Composable
fun Error(action: () -> Unit= {}){
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(16.dp)
            .height(48.dp),
        backgroundColor = Color.Red,
        shape = Shapes.large
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(7f)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    tint = Color.White,
                    contentDescription = stringResource(id = R.string.label_error),
                )
                Text(
                    text = stringResource(id = R.string.label_error),
                    color = Color.White
                )
            }
            TextButton(
                modifier = Modifier
                    .weight(3f),
                onClick = action
            ){
                Text(
                    text = stringResource(id = R.string.label_reload),
                    color = Color.White
                )
            }
        }
    }
}