package com.jahr.practica1.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector
import com.jahr.practica1.navigation.NavScreen

sealed class Items_options_config_JAHR(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    object item_config1 : Items_options_config_JAHR(
        Icons.Filled.LightMode,
        "Tema",
        NavScreen.TemaScren.name
    )
    object item_config2 : Items_options_config_JAHR(
        Icons.Filled.Notifications,
        "Notificaciones",
        NavScreen.NotificacionesScreen.name
    )
    object item_config3 : Items_options_config_JAHR(
        Icons.Filled.Attachment,
        "Guardados",
        NavScreen.GuardadoScreen.name
    )


}