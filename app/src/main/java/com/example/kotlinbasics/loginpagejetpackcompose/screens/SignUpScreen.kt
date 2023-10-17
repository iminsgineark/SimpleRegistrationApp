package com.example.kotlinbasics.loginpagejetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
// import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinbasics.loginpagejetpackcompose.R
import com.example.kotlinbasics.loginpagejetpackcompose.components.ButtonComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.CheckBoxComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.ClickableLoginTextComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.DividerTextComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.HeadingComponent
import com.example.kotlinbasics.loginpagejetpackcompose.components.MyPasswordField
import com.example.kotlinbasics.loginpagejetpackcompose.components.MyTextField
import com.example.kotlinbasics.loginpagejetpackcompose.components.NormalTextComponent
import com.example.kotlinbasics.loginpagejetpackcompose.navigation.PostOfficeAppRouter
import com.example.kotlinbasics.loginpagejetpackcompose.navigation.Screen

@Composable
fun SignUpScreen() {
    Surface(
     modifier = Modifier
         .fillMaxSize()
         .background(Color.White)
         .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.Hello))
            HeadingComponent(value = stringResource(id = R.string.createAccount))
            Spacer(modifier = Modifier.height(20.dp))
           MyTextField(
               labelValue = stringResource(id = R.string.firstName),
               painterResource(id = R.drawable.profileuser)
           )
            MyTextField(
                labelValue = stringResource(id = R.string.lastName),
                painterResource = painterResource(id = R.drawable.profileuser)
            )
            MyTextField(
                labelValue = stringResource(id = R.string.Email),
                painterResource = painterResource(id = R.drawable.email)
            )

            MyPasswordField(labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock))
            Spacer(modifier = Modifier.height(10.dp))
            CheckBoxComponent(value = stringResource(id = R.string.termsConditions),
                onTextSelected = {
                    PostOfficeAppRouter.NavigateTo(Screen.TermsAndConditionsScreen)
                })
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register))
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = true,onTextSelected = {
                PostOfficeAppRouter.NavigateTo(Screen.LoginScreen)
            })

        }

    }
}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
 }