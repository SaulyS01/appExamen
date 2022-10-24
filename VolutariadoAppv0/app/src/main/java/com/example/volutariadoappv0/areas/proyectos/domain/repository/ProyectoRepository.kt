package com.example.volutariadoappv0.areas.proyectos.domain.repository

import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import kotlinx.coroutines.flow.Flow

interface ProyectoRepository {

    fun getProyectos(): Flow<List<Proyecto>>

    suspend fun getProyectoById(id: Int): Proyecto?

    suspend fun insertProyecto(proyecto: Proyecto)

    suspend fun deleteProyecto(proyecto: Proyecto)
}