package com.example.idnplab08.model.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SalaWithPinturas (
    @Embedded
    val sala: SalaEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "salaId"
    )
    val pinturas: List<PinturaEntity>
)