package com.example.volutariadoappv0.areas.proyectos.data.source.local.dao

import androidx.room.*
import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProyectoDao {
    @Query("SELECT * FROM Proyecto")
    fun getProyectos(): Flow<List<Proyecto>>

    @Query("SELECT * FROM Proyecto WHERE id = :id")
    suspend fun getProyectoById(id: Int): Proyecto?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProyecto(proyecto: Proyecto)

    @Delete
    suspend fun deleteProyecto(proyecto: Proyecto)
}