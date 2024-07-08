package com.example.idnplab08.model.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idnplab08.model.database.entity.AutorEntity


@Dao
interface AutorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(autor: AutorEntity)

    @Delete
    fun delete(autor: AutorEntity)

    @Query("SELECT * FROM autor")
    fun getAll(): List<AutorEntity>

    @Query("SELECT * FROM autor WHERE id = :id")
    fun getById(id: Int): AutorEntity
}