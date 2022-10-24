package com.example.volutariadoappv0.areas.proyectos.data.repository

import com.example.volutariadoappv0.areas.proyectos.data.source.local.dao.ProyectoDao
import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import com.example.volutariadoappv0.areas.proyectos.domain.repository.ProyectoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProyectoRepositoryImp @Inject constructor(
    private val dao: ProyectoDao

): ProyectoRepository {
    override fun getProyectos(): Flow<List<Proyecto>> {
        return dao.getProyectos()
    }

    override suspend fun getProyectoById(id: Int): Proyecto? {
        return dao.getProyectoById(id)
    }

    override suspend fun insertProyecto(proyecto: Proyecto) {
        return dao.insertProyecto(proyecto)
    }

    override suspend fun deleteProyecto(proyecto: Proyecto) {
        return dao.deleteProyecto(proyecto)
    }
}