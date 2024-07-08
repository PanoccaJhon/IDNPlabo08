package com.example.idnplab08.model.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.idnplab08.model.database.entity.PinturaEntity

@Dao
interface PinturaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pintura: PinturaEntity)

    @Delete
    fun delete(pintura: PinturaEntity)

    @Query("SELECT * FROM pintura")
    fun getAll(): List<PinturaEntity>

    @Query("SELECT * FROM pintura WHERE id = :id")
    fun getById(id: Int): PinturaEntity
}