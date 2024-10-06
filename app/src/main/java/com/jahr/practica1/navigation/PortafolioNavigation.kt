package com.jahr.practica1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jahr.practica1.screens.BlogScreen
import com.jahr.practica1.screens.CuentaScreen
import com.jahr.practica1.screens.HomeScreen
import com.jahr.practica1.screens.ProductosScreen

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
    }
}