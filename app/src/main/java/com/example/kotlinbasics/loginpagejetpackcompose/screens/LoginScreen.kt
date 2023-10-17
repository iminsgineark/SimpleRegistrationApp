package com.example.kotlinbasics.loginpagejetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinbasics.loginpagejetpackcompose.components.NormalTextComponent
import com.example.kotlinbasics.loginpagejetpackcompose.R
import com.example.kotlinbasics.loginpagejetpackcompose.components.ButtonComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.ClickableLoginTextComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.DividerTextComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.HeadingComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.MyTextField
import com.example.kotlinbasics.loginpagejetpackcompose.components.UnderLineNormalTextComponent

@Composable
fun LoginScreen(){

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.login))
            HeadingComponent(value = stringResource(id =R.string.welcomeback ))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = stringResource(id = R.string.Email), painterResource = painterResource(
                id = R.drawable.email
            ))
            MyTextField(labelValue = stringResource(id = R.string.password), painterResource = painterResource(
                id = R.drawable.ic_lock
            ))
            Spacer(modifier = Modifier.height(40.dp))
            UnderLineNormalTextComponent(value = stringResource(id = R.string.forgotPassword))
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false ,onTextSelected = {

            })
        }

    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}