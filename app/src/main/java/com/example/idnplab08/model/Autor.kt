package com.example.idnplab08.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "autor")
data class Autor (
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    val nombre:String?,
    val apellido:String?
)