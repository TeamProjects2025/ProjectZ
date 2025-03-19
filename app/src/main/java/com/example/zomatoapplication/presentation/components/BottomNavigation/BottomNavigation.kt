package com.example.zomato.BottomNavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomato.BottomNavigation.Pages.Delivery
import com.example.zomato.BottomNavigation.Pages.Dining
import com.example.zomato.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    val navItems = listOf(
        NavItem("Delivery", painterResource(id = R.drawable.img)),
        NavItem("Dining", painterResource(id = R.drawable.img_1)),
        NavItem("District", painterResource(id = R.drawable.img_2))
    )

    var selectedIndex by remember { mutableIntStateOf(0) }
    var showBottomSheet by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()

    // Custom colors to match the image
    val SelectedRed = Color.Green
    val unselectedGray = Color.Black
    val Blinkit = Color.Yellow

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                navItems.forEachIndexed { index, navItem ->
                    val selected = index == selectedIndex

                    val itemColor = when {
                        index == 0 && selected -> SelectedRed
                        index == 2 -> Blinkit
                        else -> unselectedGray
                    }

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            if (index == 2) {

                                showBottomSheet = true
                                
                            } else {
                                selectedIndex = index
                                showBottomSheet = false
                            }
                        },
                        icon = {
                            when (index) {
                                0 -> {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .padding(start = 12.dp)
                                            .clickable(
                                                interactionSource = remember { MutableInteractionSource() },
                                                indication = null
                                            ) {

                                                selectedIndex=0
                                            }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.img_5),
                                            contentDescription = "Delivery",
                                            modifier = Modifier.size(32.dp),
                                            tint = if (selected) Color.Red else unselectedGray
                                        )

                                        Text(
                                            text = "Delivery",
                                            color = if (selected) Color.Red else unselectedGray,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 20.sp,
                                            modifier = Modifier.padding(start = 4.dp)
                                        )
                                    }
                                }

                                1 -> {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .padding(start = 16.dp)
                                            .clickable(
                                                interactionSource = remember { MutableInteractionSource() },
                                                indication = null
                                            ) {


                                                selectedIndex=1
                                            }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.img_6),
                                            contentDescription = "Dining",
                                            modifier = Modifier.size(34.dp),
                                            tint = if (selected) Color.Red else unselectedGray
                                        )
                                        Text(
                                            text = "Dining",
                                            color = if (selected) Color.Red else unselectedGray,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 20.sp,
                                            modifier = Modifier.padding(start = 6.dp)
                                        )
                                    }
                                }
                                2 -> {
                                    androidx.compose.material3.Surface(
                                        color = Color(0xFFFFC827), // Blinkit yellow
                                        shape = androidx.compose.foundation.shape.RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                                        modifier = Modifier.padding(start = 20.dp)

                                    ){
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .padding(horizontal = 10.dp, vertical = 8.dp)
                                                .clickable(
                                                    interactionSource = remember { MutableInteractionSource() },
                                                    indication = null
                                                ) {
                                                    showBottomSheet=true

                                                }
                                        ) {
                                            Text(
                                                text = "blink",
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 18.sp
                                            )
                                            Text(
                                                text = "it",
                                                color = Color(0xFF1C8C3D), // Green color
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 18.sp
                                            )
                                            Icon(
                                                painter = painterResource(id = R.drawable.baseline_arrow_outward_24),
                                                contentDescription = "Arrow",
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .padding(start = 2.dp),
                                                tint = Color.Black
                                            )
                                        }
                                    }
                                }
                            }
                        },
                        label = {
                            // Empty label
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = if (index == 2) Blinkit else SelectedRed,
                            unselectedIconColor = unselectedGray,
                            selectedTextColor = if (index == 2) Blinkit else SelectedRed,
                            unselectedTextColor = unselectedGray,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (selectedIndex) {
                0 -> Delivery(Modifier)
                1 -> Dining(Modifier)
                2 -> {
                    LaunchedEffect(selectedIndex) {
                        showBottomSheet = true
                    }
                }
            }
        }
    }

    // Bottom Sheet
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            // Content of the bottom sheet
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Blinkit logo/header
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "blink",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "it",
                        color = Color(0xFF1C8C3D), // Green color
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }

                // Bottom sheet content
                Text(
                    text = "Get everything delivered in minutes",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // More content can be added here
                Text(
                    text = "Grocery, Fruits, Vegetables and more",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // Button or action
                androidx.compose.material3.Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFC827) // Blinkit yellow
                    )
                ) {
                    Text(
                        text = "Open Blinkit",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                // Add padding at the bottom to ensure content is visible above the sheet's drag handle
                Box(modifier = Modifier.padding(bottom = 32.dp))
            }
        }
    }
}


