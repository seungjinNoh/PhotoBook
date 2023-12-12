package com.example.photobook.ui.main

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
fun Setting(
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Setting Screen",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        BottomNavigation(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            val sections = listOf(MainSection.HOME, MainSection.MAP, MainSection.SETTING)

            sections.forEach { section ->
                BottomNavigationItem(
                    selected = false,
                    onClick = { onNavigateToRoute(section.route) },
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
}