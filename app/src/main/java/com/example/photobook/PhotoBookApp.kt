package com.example.photobook

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.photobook.ui.edit.Edit
import com.example.photobook.ui.navigation.MainScreen
import com.example.photobook.ui.navigation.rememberPhotoBookNavController
import com.example.photobook.ui.main.MainSection
import com.example.photobook.ui.main.addMainGraph
import com.example.photobook.ui.theme.PhotoBookTheme

@Composable
fun PhotoBookApp() {
    PhotoBookTheme {
        val photoBookNavController = rememberPhotoBookNavController()
        NavHost(
            navController = photoBookNavController.navController,
            startDestination = MainScreen.MAIN
        ) {
            photoBookNavGraph(
                upPress = photoBookNavController::upPress,
                onNavigateToRoute = photoBookNavController::navigateToBottomBarRoute,
                onEditSelected = photoBookNavController::navigateToEdit
            )
        }
    }
}

private fun NavGraphBuilder.photoBookNavGraph(
    upPress: () -> Unit,
    onNavigateToRoute: (String) -> Unit,
    onEditSelected: (NavBackStackEntry) -> Unit
) {
    navigation(
        route = MainScreen.MAIN,
        startDestination = MainSection.HOME.route
    ) {
        addMainGraph(
            onNavigateToRoute = onNavigateToRoute,
            onEditSelected = onEditSelected
        )
    }
    composable(
        route = "${MainScreen.EDIT}/{${MainScreen.PHOTO_ID}}",
        arguments = listOf(navArgument(MainScreen.PHOTO_ID) { type = NavType.StringType })
    ) { backStackEntry ->
        val photoId = backStackEntry.arguments?.getString(MainScreen.PHOTO_ID) ?: ""
        Edit(upPress = upPress, photoId = photoId)
    }



}