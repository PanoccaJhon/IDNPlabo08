package com.example.idnplab08.model.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.idnplab08.model.dto.PinturaDescription

@Dao
interface DescriptionPinturaDao {

    @Transaction
    @Query("SELECT " +
            "p.title, a.name || ' ' || a.lastName " +
            "AS " +
            "autorNombre, p.tecnique, p.category, p.description, p.year, p.imageUrl " +
            "FROM " +
            "pintura p " +
            "INNER JOIN " +
            "autor a " +
            "ON " +
            "p.authorId = a.id " +
            "WHERE p.id = :id")
    fun getPinturaDescriptionById(id: Int): PinturaDescription
}