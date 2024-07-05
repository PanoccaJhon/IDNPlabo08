package com.example.idnplab08.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pintura")
data class Pintura(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val titulo: String,
    val autorId: Int,
    val sala: Sala,
    val tecnica: String,
    val categoria: String,
    val descripcion: String,
    val anio: Int,
    val imagenUrl: String
)