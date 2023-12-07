package com.example.photobook.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun Home(
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        Text(
            text = "Home Screen",
            modifier = Modifier.align(Alignment.Center)
        )
    }
    
    BottomNavigation(
    ) {
        val sections = listOf(MainSection.HOME, MainSection.MAP, MainSection.SETTING)

        sections.forEach { section ->
            BottomNavigationItem(
                selected = false,
                onClick = { },
                icon = {
                    Icon(
                        imageVector = section.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = section.title),
                        style = MaterialTheme.typography.caption
                    )
                }
            )
        }
    }

}