package com.jahr.practica1.components

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Motorcycle
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.ConnectedTv
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Motorcycle
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jahr.practica1.MainViewModelJAHR
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(
    drawerState: DrawerState
){
    val scope = rememberCoroutineScope()
    var showMenu by remember{mutableStateOf( false)}
    var mainViewModelJAHR : MainViewModelJAHR = viewModel()
    CenterAlignedTopAppBar(
        title = { Text(text= "Desig JAHR",
        style = MaterialTheme.typography.bodyMedium)
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch{
                    drawerState.open()
                }
            }) {
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Abrir menu lateral"
            )
        }
        },
        actions={
            IconButton(onClick = {mainViewModelJAHR.showBottomSheet = true}){
                Icon(imageVector = Icons.Outlined.Settings,
                    contentDescription = "Configuración")
            }
            IconButton(onClick = { showMenu = !showMenu}){
                Icon(imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "Mas opciones")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = {showMenu = false}
            ){
                DropdownMenuItem(
                    leadingIcon = {Icon(Icons.Filled.ConnectedTv, contentDescription = null)},
                    text = { Text(text = "Asesorias") },
                    onClick = {}
                )
                DropdownMenuItem(
                    leadingIcon = {Icon(Icons.Filled.Category, contentDescription = null)},
                    text = { Text(text = "Promociones") },
                    onClick = {}
                )
                DropdownMenuItem(
                    leadingIcon = {Icon(Icons.Filled.Favorite, contentDescription = null)},
                    text = { Text(text = "Favoritos") },
                    onClick = {
                        showMenu=false
                        mainViewModelJAHR.showDialogFavoritos = true
                    }
                )
            }
        }
    )
}