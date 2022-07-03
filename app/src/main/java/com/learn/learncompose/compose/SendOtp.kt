package com.learn.learncompose.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.learn.learncompose.R
import com.learn.learncompose.SendOtpUiState
import com.learn.learncompose.SendOtpViewModelState
import com.learn.learncompose.viewmodel.SendOtpViewModel

@Composable
fun SendOtp(
    viewModel: SendOtpViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.enter_mobile_number),
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 10.dp),
            value = uiState.phone,
            onValueChange = {
                if (it.isDigitsOnly() && it.length <= 10) {
                    viewModel.onPhoneEntered(it)
                }
            },
            placeholder = {
                Text(text = stringResource(id = R.string.enter_mobile_number_hint))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            modifier = Modifier.padding(horizontal = 10.dp),
            onClick = {
                viewModel.sentOtp()
            }, enabled = uiState.enableSendOtpButton
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.send_otp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        if (uiState.showLoadingState) {
            CircularProgressIndicator()
        }
        Spacer(modifier = Modifier.height(25.dp))
        if (uiState.showErrorState) {
            Error(action = { viewModel.resendOtp() })
        }
        Spacer(modifier = Modifier.height(15.dp))
        if(uiState.sendOtpSuccess){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.label_otp_sent_success),
                textAlign = TextAlign.Center
            )
        }
    }
}