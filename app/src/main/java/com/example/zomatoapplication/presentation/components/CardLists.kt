package com.android.bottomsheet.components



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoapplication.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardLists(drawable: Int,text: String) {
    Card(onClick = {},
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(width = 0.3.dp, color = colorResource(id = R.color.gray)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "Free Coke",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(colorResource(id = R.color.lightYellow))
                    .size(70.dp)
                    .padding(start = 10.dp))
            Text(text = text,
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

        }

    }
}
