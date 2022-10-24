package com.example.volutariadoappv0.areas.proyectos.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.volutariadoappv0.areas.proyectos.screens.proyecto.edit.EditScreen
import com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Edit.route,
            arguments = listOf(
                navArgument(
                    name = "proyectoId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            EditScreen(navController = navController)
        }
    }

}