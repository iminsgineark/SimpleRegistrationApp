package com.example.kotlinbasics.loginpagejetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinbasics.loginpagejetpackcompose.R
import com.example.kotlinbasics.loginpagejetpackcompose.components.HeadingComponent

@Composable
fun TermsAndConditonsScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)) {
        HeadingComponent(value = stringResource(id = R.string.termsAndconditions))
    }

}

@Preview
@Composable
fun TermsAndConditonsPreview(){
    TermsAndConditonsScreen()
}