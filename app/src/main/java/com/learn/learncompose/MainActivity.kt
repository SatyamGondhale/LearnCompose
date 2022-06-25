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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.learn.learncompose.screens.Home
import com.learn.learncompose.screens.ScreenOne
import com.learn.learncompose.screens.ScreenThree
import com.learn.learncompose.screens.ScreenTwo
import com.learn.learncompose.ui.theme.LearnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") {
                            Home(navigateToScreenOne = {
                                navController.navigate("screenOne")
                            })
                        }
                        composable(
                            route = "screenOne", arguments = listOf(
                            )
                        ) {
                            ScreenOne(navigateToScreenTwo = {
                                navController.navigate("screenTwo/${"This is Data For Screen Two"}")
                            })
                        }
                        composable(route = "screenTwo/{dataForScreenTwo}") {
                            navArgument(name = "dataForScreenTwo") {
                                type = NavType.StringType
                            }
                            val getData = it.arguments?.getString("dataForScreenTwo")
                            ScreenTwo(getData = getData, navigateToScreenThree = {
                                navController.navigate("screenThree")
                            })
                        }
                        composable(route = "screenThree") {
                            ScreenThree(goBackToScreenTwo = {
                                navController.popBackStack()
                            })
                        }
                    }
                }

            }
        }
    }
}
