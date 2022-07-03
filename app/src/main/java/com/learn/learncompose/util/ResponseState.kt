package com.learn.learncompose.util

sealed class ResponseState {
    object Success : ResponseState()
    object Failure : ResponseState()
    object Loading : ResponseState()
}
