package com.example.zomatoapplication.presentation.navigation

import kotlinx.serialization.Serializable

sealed class SubNavigation {

    @Serializable
    object LoginSignUpScreen : SubNavigation()

    @Serializable
    object MainHomeScreen : SubNavigation()

}

sealed class Routes {

    @Serializable
    object LoginScreen : Routes()

    @Serializable
    object SignUpScreen : Routes()

    @Serializable
    object DeliveryHomeScreen : Routes()

    @Serializable
    object DiningScreen : Routes()

    @Serializable
    object CartScreen : Routes()


}