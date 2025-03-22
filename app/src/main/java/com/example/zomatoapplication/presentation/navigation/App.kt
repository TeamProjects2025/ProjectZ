package com.example.zomato.BottomNavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

import androidx.navigation.compose.rememberNavController
import com.example.zomatoapplication.presentation.navigation.Routes
import com.example.zomatoapplication.presentation.navigation.SubNavigation
import com.example.zomatoapplication.presentation.screens.SignUpScreen
import com.google.firebase.auth.FirebaseAuth



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    val navController = rememberNavController()
    var startScreen = if (true) {

        SubNavigation.LoginSignUpScreen

    } else {

        SubNavigation.MainHomeScreen

    }

    Scaffold() { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            NavHost(navController = navController, startDestination = startScreen) {

                navigation<SubNavigation.LoginSignUpScreen>(startDestination = Routes.LoginScreen) {
                    composable<Routes.LoginScreen> {

                        // here call the login screen
                    }

                    composable<Routes.SignUpScreen> {
                        SignUpScreen()
                    }
                }

                navigation<SubNavigation.MainHomeScreen>(startDestination = Routes.DeliveryHomeScreen) {

                    composable<Routes.DeliveryHomeScreen> {
                        // here call the delivery home screen
                    }
                }
            }


        }


    }


}


