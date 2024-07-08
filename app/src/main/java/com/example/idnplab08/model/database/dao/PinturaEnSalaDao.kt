package com.example.idnplab08.model.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.idnplab08.model.dto.PinturaEnMapa

@Dao
interface PinturaEnSalaDao {
    @Query("""
        SELECT s.name AS salaNombre, p.title, a.name || ' ' || a.lastName AS autorNombre, p.imageUrl
        FROM pintura p
        INNER JOIN sala s ON p.salaId = s.id
        INNER JOIN autor a ON p.authorId = a.id
        WHERE p.id = :pinturaId
    """)
    fun getPinturaEnSalaPorId(pinturaId: Int): PinturaEnMapa
}