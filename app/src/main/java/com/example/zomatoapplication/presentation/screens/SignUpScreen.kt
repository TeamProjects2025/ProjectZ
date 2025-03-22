package com.example.zomatoapplication.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoapplication.R


@Composable
fun SignUpScreen(){
      Column(
          modifier = Modifier.fillMaxSize()
      ) {
          Box(modifier = Modifier.fillMaxWidth().size(185.dp)){
              Image(painter = painterResource(R.drawable.zomato),
                  contentDescription = "Zomato Image")
              Button(onClick = {},
                  modifier = Modifier.padding(start = 310.dp, top = 25.dp).clip(CircleShape).size(width = 78.dp, height = 35.dp),
                  colors = ButtonDefaults.buttonColors(
                      containerColor = Color.DarkGray.copy(alpha = 0.8f), contentColor = Color.LightGray
                  ), shape = CircleShape,
                  ) {
                  Text(text = "Skip")
              }
          }
          Spacer(modifier = Modifier.height(6.dp))
          Text(text = "Get Started",
              modifier = Modifier
                  .align(Alignment.CenterHorizontally),
               fontSize = 44.sp, fontWeight = FontWeight.Bold)
          Text(text = "by creating a free account",
              modifier = Modifier.align(Alignment.CenterHorizontally),
              fontSize = 16.sp)
          Spacer(modifier = Modifier.height(20.dp))
          MyTextField(placeholderValue = "Full Name", painterResource(R.drawable.userprofile))
          Spacer(modifier = Modifier.height(8.dp))
          MyTextField(placeholderValue = "Email", painterResource(R.drawable.mail))
          Spacer(modifier = Modifier.height(8.dp))
          MyTextField(placeholderValue = "Address", painterResource(R.drawable.address))
          Spacer(modifier = Modifier.height(8.dp))
          PasswordTextField(placeholderValue = "Password", painterResource(R.drawable.padlock))
          Spacer(modifier = Modifier.height(10.dp))
          PasswordTextField(placeholderValue = "Confirm Password", painterResource(R.drawable.padlock))
          Spacer(modifier = Modifier.height(5.dp))
          CheckboxComponent(value = stringResource(id = R.string.term_conditions))
          Spacer(modifier = Modifier.height(20.dp))
          SignupButton()
          OrComponent()
      }
}

@Composable
fun MyTextField(placeholderValue: String, painterResource: Painter){
     val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = {textValue.value = it},
        placeholder = { Text(text = placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.LightGray, focusedBorderColor = Color.LightGray),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {Icon(painter = painterResource,
            contentDescription = "Icon",
            modifier = Modifier.size(20.dp),
            tint = Color.Gray
            )}
    )

}

@Composable
fun PasswordTextField(placeholderValue: String, painterResource: Painter){
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = {passwordValue.value = it},
        placeholder = { Text(text = placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color.LightGray, focusedBorderColor = Color.LightGray),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(painter = painterResource,
            contentDescription = "Icon",
            modifier = Modifier.size(20.dp),
            tint = Color.Gray
                )},
        trailingIcon = {
                val iconImage = if (passwordVisible.value){
                 Icons.Filled.Visibility
                }else{
                 Icons.Filled.VisibilityOff
                }
            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            }else{
                stringResource(id = R.string.show_password)
            }

             IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                 Icon(imageVector = iconImage, contentDescription = description, tint = Color.Gray)
             }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )
}

@Composable
fun CheckboxComponent(value:String){
    val context = LocalContext.current
    val checkState = remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth().heightIn(45.dp).padding(start = 16.dp, end = 16.dp)) {
        Checkbox(checked = checkState.value,
            onCheckedChange = {
                checkState.value != checkState.value
            },
            colors = CheckboxDefaults.colors(uncheckedColor = Color.Gray))
        Text(value,Modifier.padding(top = 11.dp), fontSize = 11.sp)
        Text("Term",Modifier.padding(start = 2.dp, top = 11.dp).clickable {
            Toast.makeText(context,"Term and Conditions",Toast.LENGTH_LONG).show()
        }, fontSize = 11.sp, color = Color.Red)
        Text("and",Modifier.padding(start = 2.dp, top = 11.dp, end = 2.dp), fontSize = 11.sp)
        Text("Conditions",Modifier.padding(top = 11.dp).clickable {
            Toast.makeText(context,"Term and Conditions",Toast.LENGTH_LONG).show()
        }, fontSize = 11.sp, color = Color.Red)
    }
}

@Composable
fun SignupButton(){
    val context = LocalContext.current
    Button(onClick = {
          Toast.makeText(context,"SignUp Button",Toast.LENGTH_SHORT).show()
    },
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, bottom = 14.dp).height(50.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.buttonColor)),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
        ) {
        Row(modifier = Modifier.fillMaxWidth().padding(4.dp),Arrangement.Center) {
            Text("Next", fontSize = 22.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = null, modifier = Modifier.padding(top = 4.dp).size(20.dp))
        }
    }
    Row(modifier = Modifier.fillMaxWidth(),Arrangement.Center) {
        Text("Already a member?")
        Spacer(modifier = Modifier.width(2.dp))
        Text("Login in",
            modifier = Modifier.clickable {
                Toast.makeText(context,"Go to Login Screen",Toast.LENGTH_LONG).show()
            },
            color = Color.Red)
    }

}

@Composable
fun OrComponent(){
    Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, bottom = 8.dp, end = 16.dp, top = 16.dp),Arrangement.SpaceEvenly,Alignment.CenterVertically) {
        HorizontalDivider(modifier = Modifier.width(160.dp), color = Color.LightGray, thickness = 0.8.dp)
        Text(text = "or")
        HorizontalDivider(modifier = Modifier.width(160.dp), color = Color.LightGray, thickness = 0.8.dp)

    }
    Spacer(modifier = Modifier.height(1.dp))
    Row(modifier = Modifier.fillMaxWidth(),Arrangement.Center) {
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.google),
                modifier = Modifier.size(60.dp).border(width = 1.dp, color = Color.LightGray,CircleShape).padding(10.dp),
                tint = Color.Unspecified,
                contentDescription = "Google Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview(){
    SignUpScreen()
}