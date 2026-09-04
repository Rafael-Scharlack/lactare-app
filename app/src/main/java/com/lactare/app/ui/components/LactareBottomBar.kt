package com.lactare.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.lactare.app.navigation.BottomNavItem

@Composable
fun LactareBottomBar(
    currentRoute: String?,
    onItemClick: (BottomNavItem) -> Unit
) {
    NavigationBar {
        BottomNavItem.entries.forEach { item ->
            val icon = when (item) {
                BottomNavItem.HOME -> Icons.Filled.Home
                BottomNavItem.PONTOS -> Icons.Filled.LocationOn
                BottomNavItem.RASTREAMENTO -> Icons.Filled.Timeline
                BottomNavItem.MAIS -> Icons.Filled.Menu
            }
            NavigationBarItem(
                selected = currentRoute == item.destination.route,
                onClick = { onItemClick(item) },
                icon = { Icon(icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}
