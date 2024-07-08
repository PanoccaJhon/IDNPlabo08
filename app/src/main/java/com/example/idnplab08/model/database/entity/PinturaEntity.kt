package com.example.idnplab08.model.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pintura")
data class PinturaEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "title")
    val titulo: String,
    @ColumnInfo(name = "authorId")
    val autorId: Int,
    @ColumnInfo(name = "salaId")
    val salaId: Int,
    @ColumnInfo(name = "tecnique")
    val tecnica: String,
    @ColumnInfo(name = "category")
    val categoria: String,
    @ColumnInfo(name = "description")
    val descripcion: String,
    @ColumnInfo(name = "year")
    val anio: Int,
    @ColumnInfo(name = "imageUrl")
    val imagenUrl: String
)