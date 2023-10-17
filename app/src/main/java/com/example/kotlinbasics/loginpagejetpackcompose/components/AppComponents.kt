package com.example.kotlinbasics.loginpagejetpackcompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinbasics.loginpagejetpackcompose.R
import com.example.kotlinbasics.loginpagejetpackcompose.ui.theme.GrayColor
import com.example.kotlinbasics.loginpagejetpackcompose.ui.theme.Primary
import com.example.kotlinbasics.loginpagejetpackcompose.ui.theme.Secondary
import com.example.kotlinbasics.loginpagejetpackcompose.ui.theme.TextColor
import com.example.kotlinbasics.loginpagejetpackcompose.ui.theme.componentShapes

@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}


@Composable
fun HeadingComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyTextField(labelValue: String){
//    val textValue = remember {
//        mutableStateOf("")
//    }
//
//    OutlinedTextField(
//        label = { Text(text = labelValue) }
//        ,value = textValue,
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//             focusedBorderColor = colorResource(id = R.color.colorPrimary),
//            focusedLabelColor =  colorResource(id = R.color.colorPrimary),
//            cursorColor =  colorResource(id = R.color.colorPrimary)
//        ),
//        keyboardOptions = KeyboardOptions.Default,
//        onValueChange = {
//        textValue.value = it
//    }
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, painterResource: Painter) {

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        value = textValue.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
           Icon(painter = painterResource, modifier = Modifier.size(15.dp) , contentDescription = "" )
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPasswordField(labelValue: String, painterResource: Painter) {
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        value = password.value,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, modifier = Modifier.size(15.dp) , contentDescription = "" )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility;
            }
            else{
                Icons.Filled.VisibilityOff;
            }
            var description = if (passwordVisible.value){
                stringResource(id = R.string.hidePassword)
            }
            else{
                stringResource(id = R.string.showPassword)
            }
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else{
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun CheckBoxComponent(value: String,onTextSelected : (String) -> Unit){
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically)
    {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked =checkedState.value , onCheckedChange = {
            checkedState.value = !checkedState.value
        } )

        ClickableTextComponent(value = value,onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String,onTextSelected : (String) -> Unit){
    val initialText = "By Continuing You Accept Our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "  and  "
    val termsAndConditionsText = " Terms Of Use "

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }
    ClickableText(text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent","{$span}")
                if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)){
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ButtonComponent(value: String){
    Button(onClick = {

    }, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp), contentPadding = PaddingValues(), colors = ButtonDefaults.buttonColors(
        Color.Transparent
    )) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center) {
            Text(text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )
        }
    }
}


@Composable
fun DividerTextComponent(){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), color = GrayColor, thickness = 1.dp)

        Text(modifier = Modifier.padding(8.dp),text = "or", fontSize = 18.sp, color = TextColor)

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), color = GrayColor, thickness = 1.dp)
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true,onTextSelected : (String) -> Unit){
    val initialText = if (tryingToLogin) "Already Have An Account?" else "Don't Have An Account Yet? Register"
    val LoginText = if (tryingToLogin) "Login?" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)){
            pushStringAnnotation(tag = LoginText, annotation = LoginText)
            append(LoginText)
        }
    }
    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
//        color = colorResource(id = R.color.colorText),
//        textAlign = TextAlign.Center


        text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span->
                Log.d("ClickableTextComponent","{$span}")
                if ((span.item == LoginText)){
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun UnderLineNormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}