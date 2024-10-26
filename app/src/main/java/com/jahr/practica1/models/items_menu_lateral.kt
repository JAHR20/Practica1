package com.jahr.practica1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.EmojiObjects
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import com.jahr.practica1.navigation.NavScreen

sealed class items_menu_lateral(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    object item_menu_lateral1 : items_menu_lateral(
        Icons.Filled.Home,
        "Inicio",
        NavScreen.HomeScreen.name
    )
    object item_menu_lateral2 : items_menu_lateral(
        Icons.Filled.EmojiObjects,
        "Productos",
        NavScreen.ProductoScreen.name
    )
    object item_menu_lateral3 : items_menu_lateral(
        Icons.Filled.Share,
        "Blog",
        NavScreen.BlogScreen.name
    )
    object item_menu_lateral4 : items_menu_lateral(
        Icons.Filled.Person,
        "Cuenta",
        NavScreen.CuentaScreen.name
    )

    object item_menu_lateral5 : items_menu_lateral(
        Icons.Filled.Book,
        "Tutoriales",
        NavScreen.TutorialesScreen.name
    )
    object item_menu_lateral6 : items_menu_lateral(
        Icons.Filled.Phone,
        "Atención a clientes",
        NavScreen.AtencionAClientesScreen.name
    )
    object item_menu_lateral7 : items_menu_lateral(
        Icons.Filled.Info,
        "Info",
        NavScreen.InfoScreen.name
    )

}