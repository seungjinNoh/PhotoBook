package com.example.photobook

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.example.photobook.navigation.MainScreen
import com.example.photobook.navigation.rememberPhotoBookNavController
import com.example.photobook.ui.theme.PhotoBookTheme

@Composable
fun PhotoBookApp() {
    PhotoBookTheme {
        val photoBookNavController = rememberPhotoBookNavController()
        NavHost(
            navController = photoBookNavController.navController,
            graph = MainScreen.HOME
        ) {

        }
    }
}