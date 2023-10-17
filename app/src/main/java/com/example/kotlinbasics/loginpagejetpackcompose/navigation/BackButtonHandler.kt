package com.example.kotlinbasics.loginpagejetpackcompose.navigation

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalOnBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> {
        null
    }