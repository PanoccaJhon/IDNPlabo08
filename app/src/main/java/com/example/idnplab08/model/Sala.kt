package com.example.idnplab08.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sala")
data class Sala (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val descripcion: String
)