package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.edit

sealed class EditEvent {
    data class EnteredProyecto(val value: String): EditEvent()
    data class EnteredCosto(val value: String): EditEvent()
    data class EnteredFeInicio(val value: String): EditEvent()
    data class EnteredFeFin(val value: String): EditEvent()
    data class EnteredEstado(val value: String): EditEvent()
    object InsertProyecto: EditEvent()
}