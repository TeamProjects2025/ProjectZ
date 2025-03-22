package com.android.bottomsheet.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoapplication.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BlinkitBottomSheetCardLayout(){
    val context = LocalContext.current
    Card(onClick = { /*TODO*/ },
        shape = RoundedCornerShape(25.dp),
        elevation =8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Image(painter = painterResource(id = R.drawable.blinkitlogo),
                    contentDescription = "Blinkit Logo",
                    modifier = Modifier.size(80.dp))
                Column(modifier = Modifier.padding(top = 10.dp, start = 16.dp)){
                    Text(text = "Blinkit",
                        fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "India's Last Minute App",
                        fontSize = 22.sp, color = Color.Black)
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .border(
                    BorderStroke(0.5.dp, color = colorResource(id = R.color.gray)),
                    shape = RoundedCornerShape(24.dp)
                ), Arrangement.SpaceBetween) {
                Column(modifier = Modifier
                    .padding(top = 10.dp, start = 16.dp)
                    .weight(1f)){
                    Image(
                        painter = painterResource(id = R.drawable.coke),
                        contentDescription = "Free Coke",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .size(70.dp))
                    Text(text = "Free Coke Can",
                        fontSize = 18.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.blue)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "on first order\n  above 299",
                        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                        fontSize = 14.sp,
                        color = Color.DarkGray,

                        )
                }
                Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .border(
                            BorderStroke(0.5.dp, color = colorResource(id = R.color.gray)),
                            shape = CircleShape
                        ),
                    contentDescription = null)
                Column(modifier = Modifier
                    .padding(top = 10.dp, start = 16.dp)
                    .weight(1f)){
                    Image(
                        painter = painterResource(id = R.drawable.scooter),
                        contentDescription = "Scooter", colorFilter = ColorFilter.tint(colorResource(
                            id = R.color.blue
                        )),
                        modifier = Modifier
                            .padding(start = 36.dp, top = 20.dp)
                            .size(50.dp))
                    Text(text = "Free Delivery",
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 18.sp, fontWeight = FontWeight.Bold, color = colorResource(id = R.color.blue)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "on first 4 order",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(start = 22.dp, bottom = 16.dp)
                    )
                }
            }
            Button(onClick = {
                             Toast.makeText(context,"Install Button",Toast.LENGTH_SHORT).show()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(start = 16.dp, end = 16.dp, bottom = 20.dp),
                shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.green))
            ) {
                Text(text = "Install Blinkit now", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}
