package com.jahr.practica1.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jahr.practica1.models.Items_bottom_nav.*
import com.jahr.practica1.navigation.rutaActual

@Composable
fun NavegacionInferiorJahr(navController: NavHostController){
    val items = listOf(
        Item_bottom_nav1,
        Item_bottom_nav2,
        Item_bottom_nav4,
        Item_bottom_nav3
    )

    BottomAppBar {
        NavigationBar {
            items.forEach { item->
                NavigationBarItem(
                    selected = rutaActual(navController)== item.ruta,
                    onClick = { navController.navigate(item.ruta)},
                    icon = {
                        Icon(imageVector = item.icon,
                            contentDescription = item.title)
                    },
                    label = {
                        Text(text=item.title)
                    }
                )
            }
        }
    }
}