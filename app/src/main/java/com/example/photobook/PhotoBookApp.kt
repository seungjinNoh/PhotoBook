package com.example.photobook

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
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
                onNavigateToRoute = photoBookNavController::navigateToBottomBarRoute
            )
        }
    }
}

private fun NavGraphBuilder.photoBookNavGraph(
    upPress: () -> Unit,
    onNavigateToRoute: (String) -> Unit
) {
    navigation(
        route = MainScreen.MAIN,
        startDestination = MainSection.HOME.route
    ) {
        addMainGraph(onNavigateToRoute = onNavigateToRoute)
    }
    composable(
        route = "${MainScreen.MAIN}/{${MainScreen.DETAIL_ID_KEY}}",
        arguments = listOf(navArgument(MainScreen.DETAIL_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->

    }
}