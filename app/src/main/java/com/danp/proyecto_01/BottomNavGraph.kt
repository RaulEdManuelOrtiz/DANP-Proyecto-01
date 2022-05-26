package com.danp.proyecto_01

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.danp.proyecto_01.screens.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Details.route) {
            DetailsScreen("")
        }
        composable(route = BottomBarScreen.Details.route + "/{license}") {
            val license = it.arguments?.getString("license")
            DetailsScreen(license)
        }
        composable(route = BottomBarScreen.Historial.route) {
            Conversation(SampleData.autos)
        }
    }
}
