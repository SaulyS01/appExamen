package com.example.volutariadoappv0.areas.proyectos.domain.uses

import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import com.example.volutariadoappv0.areas.proyectos.domain.repository.ProyectoRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetProyectos @Inject constructor(
    private val repository: ProyectoRepository
){
    operator fun invoke(): Flow<List<Proyecto>> {
        return repository.getProyectos()
    }
}