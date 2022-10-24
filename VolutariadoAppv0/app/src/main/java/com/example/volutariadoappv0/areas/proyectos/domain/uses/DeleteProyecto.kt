package com.example.volutariadoappv0.areas.proyectos.domain.uses

import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import com.example.volutariadoappv0.areas.proyectos.domain.repository.ProyectoRepository
import javax.inject.Inject

class DeleteProyecto @Inject constructor(
    private val repository: ProyectoRepository
){
    suspend operator fun invoke(proyecto: Proyecto) {
        repository.deleteProyecto(proyecto)
    }
}