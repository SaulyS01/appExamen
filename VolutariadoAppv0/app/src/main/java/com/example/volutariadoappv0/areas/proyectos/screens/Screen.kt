package com.example.volutariadoappv0.areas.proyectos.screens

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Edit: Screen("edit?proyectoId={proyectoId}") {
        fun passId(proyectoId: Int?): String {
            return "edit?proyectoId=$proyectoId"
        }
    }
}