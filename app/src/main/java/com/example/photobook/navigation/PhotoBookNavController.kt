package com.example.photobook.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

object MainScreen {
    const val HOME = "home"
    const val MAP = "map"
    const val TEMP = "temp"
}

@Composable
fun rememberPhotoBookNavController(
    navController: NavController = rememberNavController()
): PhotoBookNavController = remember(navController) {
    PhotoBookNavController(navController)
}

@Stable
class PhotoBookNavController(
    val navController: NavController
) {
    val currentRoute: String?
        get() = navController.currentDestination?.route
}