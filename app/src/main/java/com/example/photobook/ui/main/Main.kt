package com.example.photobook.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.photobook.R

enum class MainSection(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    HOME(R.string.title_main_home, Icons.Outlined.Home, "main/home"),
    MAP(R.string.title_main_map, Icons.Outlined.Email, "main/map"),
    SETTING(R.string.title_main_setting, Icons.Outlined.Settings, "main/map")
}

fun NavGraphBuilder.addMainGraph(
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    composable(MainSection.HOME.route) { from ->
        Home(onNavigateToRoute = onNavigateToRoute, modifier = modifier)
    }
    composable(MainSection.MAP.route) { from ->
        Map(onNavigateToRoute = onNavigateToRoute, modifier = modifier)
    }
    composable(MainSection.SETTING.route) { from ->
        Setting(onNavigateToRoute = onNavigateToRoute, modifier = modifier)
    }
}