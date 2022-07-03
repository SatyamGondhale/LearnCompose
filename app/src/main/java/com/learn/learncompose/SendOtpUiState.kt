package com.learn.learncompose

import com.learn.learncompose.util.ResponseState

/**
 * This is derivation of [SendOtpViewModelState] that has been divided into many subclasses to more
 * accurately describe the State at which UI can be rendered
 */
sealed interface SendOtpUiState {
    // parameters responsible for Controlling UI Views of Composable Screen
    val phone: String
    val enableSendOtpButton: Boolean
    val showLoadingState: Boolean
    val showErrorState: Boolean
    val sendOtpSuccess: Boolean

    // Possible States for this Send Otp Composable Screen
    data class InitialState(
        override val phone: String,
        override val enableSendOtpButton: Boolean,
        override val showLoadingState: Boolean,
        override val showErrorState: Boolean,
        override val sendOtpSuccess: Boolean
    ) : SendOtpUiState

    data class EnableButtonState(
        override val phone: String,
        override val enableSendOtpButton: Boolean,
        override val showLoadingState: Boolean,
        override val showErrorState: Boolean,
        override val sendOtpSuccess: Boolean
    ) : SendOtpUiState

    data class SendingOtpState(
        override val phone: String,
        override val enableSendOtpButton: Boolean,
        override val showLoadingState: Boolean,
        override val showErrorState: Boolean,
        override val sendOtpSuccess: Boolean
    ) : SendOtpUiState

    data class SendOtpFailedState(
        override val phone: String,
        override val enableSendOtpButton: Boolean,
        override val showLoadingState: Boolean,
        override val showErrorState: Boolean,
        override val sendOtpSuccess: Boolean
    ) : SendOtpUiState

    data class SendOtpSuccessState(
        override val phone: String,
        override val enableSendOtpButton: Boolean,
        override val showLoadingState: Boolean,
        override val showErrorState: Boolean,
        override val sendOtpSuccess: Boolean
    ) : SendOtpUiState
}


data class SendOtpViewModelState(
    // Unprocessed Parameters can be used for setting States and other conditions checks
    val phone: String = "",
    var responseState: ResponseState? = null
) {
    /**
     * Function Responsible for Transforming [SendOtpViewModelState] into a [SendOtpUiState] that is more
     * strongly typed in order to derive the UI
     */
    fun toUiState(): SendOtpUiState {
        if (phone.length == 10) {
            when (responseState) {
                is ResponseState.Loading -> {
                    return SendOtpUiState.SendingOtpState(
                        phone = phone,
                        enableSendOtpButton = false,
                        showLoadingState = true,
                        showErrorState = false,
                        sendOtpSuccess = false
                    )
                }
                is ResponseState.Failure -> {
                    return SendOtpUiState.SendOtpFailedState(
                        phone = phone,
                        enableSendOtpButton = false,
                        showLoadingState = false,
                        showErrorState = true,
                        sendOtpSuccess = false
                    )
                }
                is ResponseState.Success -> {
                    responseState = null
                    return SendOtpUiState.SendOtpSuccessState(
                        phone = "",
                        enableSendOtpButton = false,
                        showLoadingState = false,
                        showErrorState = false,
                        sendOtpSuccess = true
                    )
                }
                else -> {
                    return SendOtpUiState.EnableButtonState(
                        phone = phone,
                        enableSendOtpButton = true,
                        showLoadingState = false,
                        showErrorState = false,
                        sendOtpSuccess = false
                    )
                }
            }
        } else {
            return SendOtpUiState.InitialState(
                phone = phone,
                enableSendOtpButton = false,
                showLoadingState = false,
                showErrorState = false,
                sendOtpSuccess = false
            )
        }
    }
}