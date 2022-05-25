package com.danp.proyecto_01

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danp.proyecto_01.screens.DetailsScreen
import com.danp.proyecto_01.screens.HistorialScreen
import com.danp.proyecto_01.screens.HomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Details.route) {
            DetailsScreen()
        }
        composable(route = BottomBarScreen.Historial.route) {
            HistorialScreen()
        }
    }
}
