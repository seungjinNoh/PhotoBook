package com.example.photobook.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

object MainScreen {
    const val MAIN = "main"
    const val DETAIL = "detail"
    const val EDIT = "edit"
    const val EDIT_ID_KEY = "detailId"

    const val PHOTO_ID = "photoId"
}

@Composable
fun rememberPhotoBookNavController(
    navController: NavHostController = rememberNavController()
): PhotoBookNavController = remember(navController) {
    PhotoBookNavController(navController)
}

@Stable
class PhotoBookNavController(
    val navController: NavHostController
) {
    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(findStartDestination(navController.graph).id) {
                    saveState = true
                }
            }
        }
    }

    fun navigateToEdit(from: NavBackStackEntry) {
        if (from.lifecycleIsResumed()) {
            //todo navigation 구조 변경 후 수정 예정
            val test = "test"
            navController.navigate("${MainScreen.EDIT}/$test")
        }
    }
}

private fun NavBackStackEntry.lifecycleIsResumed() =
    this.getLifecycle().currentState == Lifecycle.State.RESUMED


private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}