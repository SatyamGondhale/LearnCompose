package com.learn.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.learncompose.compose.SendOtp
import com.learn.learncompose.compose.SendOtpSuccess
import com.learn.learncompose.ui.theme.LearnComposeTheme
import com.learn.learncompose.viewmodel.SendOtpViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "sendOtp") {
                        composable(route = "sendOtp") {
                            val sendOtpViewModel =
                                ViewModelProvider(this@MainActivity).get(SendOtpViewModel::class.java)
                            SendOtp(sendOtpViewModel)
                        }
                        composable(route = "sendOtpSuccess") {
                            SendOtpSuccess()
                        }
                    }
                }
            }
        }
    }
}