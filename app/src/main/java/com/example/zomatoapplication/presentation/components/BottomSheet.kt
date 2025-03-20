package com.example.zomatoapplication.presentation.components



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.bottomsheet.components.CardLayout
import com.android.bottomsheet.components.CardLists
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.zomatoapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun BottomSheet(){
     val scope: CoroutineScope = rememberCoroutineScope()
     val isSheetFullScreen by remember { mutableStateOf(false) }
     val modifier = if (isSheetFullScreen) Modifier.fillMaxSize() else Modifier.fillMaxWidth()
     val modalSheetState = rememberModalBottomSheetState(
          initialValue = ModalBottomSheetValue.Hidden,
          skipHalfExpanded = true,

      )
    val roundedCornerRadius = if (isSheetFullScreen) 0.dp else 20.dp
    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(
            topStart = roundedCornerRadius,
            topEnd = roundedCornerRadius
        ),
        sheetContent = {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(760.dp)) {
                LazyColumn(modifier = Modifier
                    .fillMaxSize()){
                    item {
                        BottomSheetContent(modifier = modifier)
                    }
                }
            }
        }) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            IconButton(onClick = {
                scope.launch {
                    if (modalSheetState.isVisible) modalSheetState.hide()
                    else modalSheetState.show()
                }
            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_format_align_right_24),
                    contentDescription = "BottomSheet")
            }
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent(modifier: Modifier){
    Column(modifier = Modifier.fillMaxSize().background(
        Brush.verticalGradient(
            colors = listOf(Color.Transparent, colorResource(id = R.color.yellow)),
            startY = Float.POSITIVE_INFINITY,
            endY = -200f
        ))) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
               .height(350.dp)
        )
        {
            GlideImage(
                model = R.drawable.food_shopping,
                contentDescription = "fruit-gif",
                modifier = Modifier
                    .size(270.dp).align(Alignment.BottomEnd)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(26.dp)
            ) {
                Text(
                    text = "Get Fruits & Vegetables",
                    fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "and 5000+ products",
                    fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "in 10 minutes",
                    fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CardLayout()
        Spacer(modifier = modifier.height(12.dp))
        Text(text = "* ENJOY THESE BENEFITS *",
             modifier = Modifier.align(Alignment.CenterHorizontally),
             fontSize = 18.sp, fontWeight = FontWeight.SemiBold, letterSpacing = 4.sp, color = Color.DarkGray
            )
        Spacer(modifier = modifier.height(30.dp))
        CardLists(drawable = R.drawable.foodbag, text = "Enjoy 5000+ products to suit\nyour needs")
        Spacer(modifier = modifier.height(14.dp))
        CardLists(drawable = R.drawable.clock, text = "Everything delivered\nin minutes")
        Spacer(modifier = modifier.height(14.dp))
        CardLists(drawable = R.drawable.voucher, text = "Amazing payment and\nbank offers")
        Spacer(modifier = modifier.height(14.dp))
    }
}


