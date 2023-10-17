package com.example.kotlinbasics.loginpagejetpackcompose.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.kotlinbasics.loginpagejetpackcompose.navigation.PostOfficeAppRouter
import com.example.kotlinbasics.loginpagejetpackcompose.navigation.Screen
import com.example.kotlinbasics.loginpagejetpackcompose.screens.LoginScreen
import com.example.kotlinbasics.loginpagejetpackcompose.screens.SignUpScreen
import com.example.kotlinbasics.loginpagejetpackcompose.screens.TermsAndConditonsScreen

@Composable
fun PostOfficeApp(){
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState->
            when (currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditonsScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                else -> {}
            }
        }

        SignUpScreen()
    }
}