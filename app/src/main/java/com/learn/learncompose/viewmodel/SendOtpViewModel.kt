package com.learn.learncompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.learncompose.SendOtpViewModelState
import com.learn.learncompose.util.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for handling the Business Logics of SendOtpScreen
 */
class SendOtpViewModel : ViewModel() {

    val sendOtpUiState = MutableStateFlow(SendOtpViewModelState())
    var successCounter = 0

    /**
     * stateIn - Converts a cold Flow into a hot StateFlow that is started in the given coroutine scope,
     * sharing the most recently emitted value from a single running instance of the upstream flow with multiple downstream subscribers.
     */
    val uiState = sendOtpUiState.map {
        it.toUiState()
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        sendOtpUiState.value.toUiState()
    )

    fun onPhoneEntered(phone: String) {
        sendOtpUiState.update {
            it.copy(phone = phone)
        }
    }

    fun sentOtp() {
        viewModelScope.launch(Dispatchers.IO) {
            sendOtpUiState.update {
                it.copy(responseState = ResponseState.Loading)
            }
            successCounter = successCounter + 1
            delay(5000)
            if (successCounter % 2 == 0) {
                sendOtpUiState.update {
                    it.copy(responseState = ResponseState.Success)
                }
            } else {
                sendOtpUiState.update {
                    it.copy(responseState = ResponseState.Failure)
                }
            }
        }
    }

    fun resendOtp() {
        sentOtp()
    }
}