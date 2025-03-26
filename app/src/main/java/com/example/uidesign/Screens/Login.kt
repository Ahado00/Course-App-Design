package com.example.uidesign.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF0F1F0D))
            .padding(top = 100.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(com.example.uidesign.R.string.LogInh1),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 8.dp)
            )



            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF354033), shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
                    .height(700.dp)
            ) {
                Column {

                    Text(text = stringResource(com.example.uidesign.R.string.Email), color = Color.LightGray)
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(Color(0xFF354033)),

                        placeholder = {
                            Text(text = stringResource(com.example.uidesign.R.string.EmailPH), color = Color.LightGray, fontSize = 14.sp)
                        },
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // حقل كلمة المرور
                    Text(text = stringResource(com.example.uidesign.R.string.Password), color = Color.LightGray)
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        placeholder = {
                            Text(text = stringResource(com.example.uidesign.R.string.PasswordPH), color = Color.LightGray, fontSize = 14.sp)
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = com.example.uidesign.R.drawable.off_visibility),
                                contentDescription = "Password visibility",
                                tint = Color.LightGray
                            )
                        },
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = stringResource(com.example.uidesign.R.string.Forget),
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.End)
                            .clickable { /* TODO: Navigate to login */ }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = { /* TODO: Add sign up logic */ },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF166E05)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = stringResource(com.example.uidesign.R.string.Login), fontSize = 18.sp, color = Color.White)
                    }


                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(com.example.uidesign.R.string.NoAccount),
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                        Text(
                            text = stringResource(com.example.uidesign.R.string.SignUp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF166E05),
                            modifier = Modifier.clickable { navController.navigate("SignUp") }
                        )
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    Text(
                        text = stringResource(com.example.uidesign.R.string.LogWith),
                        fontSize = 12.sp,
                        color = Color.LightGray,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(25.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 110.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)

                    ) {
                        Image(
                            painter = painterResource(id = com.example.uidesign.R.drawable.google),
                            contentDescription = "Google",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable(onClick = { /*TODO*/ })
                        )
                        Image(
                            painter = painterResource(id = com.example.uidesign.R.drawable.facebook),
                            contentDescription = "Facebook",
                            modifier = Modifier
                                .size(40.dp)
                                .clickable(onClick = { /*TODO*/ })

                        )
                    }
                }
            }
        }
    }
}
