package com.jahr.practica1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jahr.practica1.screens.AtencionAClienteScreen
import com.jahr.practica1.screens.BlogScreen
import com.jahr.practica1.screens.CuentaScreen
import com.jahr.practica1.screens.GuardadosScreen
import com.jahr.practica1.screens.HomeScreen
import com.jahr.practica1.screens.InfoScreen
import com.jahr.practica1.screens.NotificacionesScreen
import com.jahr.practica1.screens.ProductosScreen
import com.jahr.practica1.screens.TemaScreen
import com.jahr.practica1.screens.TutorialesScreen

@Composable
fun PortafolioNavigationJahr(navController: NavHostController){
    NavHost(
        navController = navController, startDestination =  NavScreen.HomeScreen.name
    ) {
        composable(NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(NavScreen.ProductoScreen.name){
            ProductosScreen()
        }
        composable(NavScreen.BlogScreen.name){
            BlogScreen()
        }
        composable(NavScreen.CuentaScreen.name){
            CuentaScreen()
        }
        composable(NavScreen.TutorialesScreen.name){
            TutorialesScreen()
        }
        composable(NavScreen.AtencionAClientesScreen.name){
            AtencionAClienteScreen()
        }
        composable(NavScreen.InfoScreen.name){
            InfoScreen()
        }

        composable(NavScreen.TemaScren.name){
            TemaScreen()
        }
        composable(NavScreen.NotificacionesScreen.name){
            NotificacionesScreen()
        }
        composable(NavScreen.GuardadoScreen.name){
            GuardadosScreen()
        }
    }
}