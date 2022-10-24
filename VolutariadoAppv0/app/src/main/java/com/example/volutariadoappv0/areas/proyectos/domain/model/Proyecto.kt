package com.example.volutariadoappv0.areas.proyectos.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Proyecto (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val proyecto: String,
    val costo: Int,
    val fe_inicio: String,
    val fe_fin: String,
    val estado: String
)