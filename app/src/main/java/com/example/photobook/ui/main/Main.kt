package com.example.photobook.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.photobook.R

sealed class MainSection(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    //todo title, icon input으로 세팅
    object HOME : MainSection(R.string.title_main_home, Icons.Outlined.Home, "main/home")
    object MAP : MainSection(R.string.title_main_map, Icons.Outlined.Email, "main/map")
    object SETTING : MainSection(R.string.title_main_setting, Icons.Outlined.Settings, "main/setting")
}

fun NavGraphBuilder.addMainGraph(
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier,
    onEditSelected: (NavBackStackEntry) -> Unit
) {
    composable(MainSection.HOME.route) { from ->
        Home(onNavigateToRoute = onNavigateToRoute, modifier = modifier, onEditClick = { onEditSelected(from) })
    }
    composable(MainSection.MAP.route) { from ->
        Map(onNavigateToRoute = onNavigateToRoute, modifier = modifier)
    }
    composable(MainSection.SETTING.route) { from ->
        Setting(onNavigateToRoute = onNavigateToRoute, modifier = modifier)
    }
}