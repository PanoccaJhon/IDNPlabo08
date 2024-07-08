package com.example.idnplab08.model.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "autor")
data class AutorEntity (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id:Int?,
    @ColumnInfo(name = "name")
    val nombre:String?,
    @ColumnInfo(name = "lastName")
    val apellido:String?
)