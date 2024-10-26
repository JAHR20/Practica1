package com.jahr.practica1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.jahr.practica1.R
import com.jahr.practica1.models.items_menu_lateral.*
import com.jahr.practica1.navigation.rutaActual
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(
    navController: NavHostController,
    drawerState: DrawerState,
    contenido: @Composable () -> Unit
){
    val items = listOf(
        item_menu_lateral1, item_menu_lateral2,
        item_menu_lateral3, item_menu_lateral4
    )
    val items2 = listOf(
        item_menu_lateral5, item_menu_lateral6,
        item_menu_lateral7
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(painterResource(id= R.drawable.code),
                    contentDescription = "Image de codigo")
                Spacer(modifier = Modifier.height(25.dp))
                items.forEach{ item ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null
                        )
                    },
                    label = { Text( text = item.title) },
                    selected = rutaActual(navController) == item.ruta,
                    onClick = {
                        navController.navigate(item.ruta)
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )

            }
            HorizontalDivider()
                items2.forEach{ item ->
                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text( text = item.title) },
                        selected = rutaActual(navController) == item.ruta,
                        onClick = {
                            navController.navigate(item.ruta)
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )

                }

            }
        }
    ) {
        contenido()
    }
}