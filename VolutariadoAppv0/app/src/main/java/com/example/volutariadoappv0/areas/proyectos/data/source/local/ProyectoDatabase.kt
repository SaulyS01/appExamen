package com.example.volutariadoappv0.areas.proyectos.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.volutariadoappv0.areas.proyectos.data.source.local.dao.ProyectoDao
import com.example.volutariadoappv0.areas.proyectos.domain.model.Proyecto

@Database(
    entities = [Proyecto::class],
    version = 1,
    exportSchema = false
)
abstract class ProyectoDatabase: RoomDatabase() {
    abstract val proyectoDao: ProyectoDao
}
