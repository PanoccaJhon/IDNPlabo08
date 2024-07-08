package com.example.idnplab08.model.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idnplab08.model.database.entity.SalaEntity

@Dao
interface SalaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sala: SalaEntity)

    @Delete
    fun delete(sala: SalaEntity)

    @Query("SELECT * FROM sala")
    fun getAll(): List<SalaEntity>

    @Query("SELECT * FROM sala WHERE id = :id")
    fun getById(id: Int): SalaEntity
}