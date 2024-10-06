package com.jahr.practica1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiObjects
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import com.jahr.practica1.navigation.NavScreen

sealed class Items_bottom_nav(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    object Item_bottom_nav1: Items_bottom_nav(
        Icons.Filled.Home,
        "Inicio",
        NavScreen.HomeScreen.name
    )
    object Item_bottom_nav2: Items_bottom_nav(
        Icons.Filled.EmojiObjects,
        "Productos",
        NavScreen.ProductoScreen.name
    )object Item_bottom_nav4: Items_bottom_nav(
        Icons.Filled.Share,
        "Blog",
        NavScreen.BlogScreen.name
    )
    object Item_bottom_nav3: Items_bottom_nav(
        Icons.Filled.Person,
        "Cuenta",
        NavScreen.CuentaScreen.name
    )


}