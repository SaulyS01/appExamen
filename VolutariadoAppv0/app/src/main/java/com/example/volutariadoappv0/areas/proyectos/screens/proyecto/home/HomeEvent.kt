package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home

import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto

sealed class HomeEvent  {
    data class DeleteProyecto(val proyecto: Proyecto): HomeEvent()
}