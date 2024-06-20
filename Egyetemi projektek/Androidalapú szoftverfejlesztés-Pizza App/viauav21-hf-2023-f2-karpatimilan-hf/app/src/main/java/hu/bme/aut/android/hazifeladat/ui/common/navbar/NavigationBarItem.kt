package hu.bme.aut.android.hazifeladat.ui.common.navbar

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItem (
    val name:String,
    val route:String,
    val icon:ImageVector,
    val badgeCount:Int
    )