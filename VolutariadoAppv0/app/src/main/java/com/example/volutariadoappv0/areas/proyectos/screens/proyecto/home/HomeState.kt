package com.example.volutariadoappv0.areas.proyectos.screens.proyecto.home;

import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto;

data class HomeState (
    val proyectos: List<Proyecto> = emptyList()
)
