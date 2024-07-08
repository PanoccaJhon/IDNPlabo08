package com.example.idnplab08.model.database.entity

import androidx.room.Embedded
import androidx.room.Relation

data class AutorWithPinturas(
    @Embedded val autor: AutorEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "autorId"
    )
    val pinturas: List<PinturaEntity>
)
