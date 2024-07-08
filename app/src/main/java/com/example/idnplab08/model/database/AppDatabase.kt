package com.example.idnplab08.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.idnplab08.model.database.dao.AutorDao
import com.example.idnplab08.model.database.dao.DescriptionPinturaDao
import com.example.idnplab08.model.database.dao.PinturaDao
import com.example.idnplab08.model.database.dao.PinturaEnSalaDao
import com.example.idnplab08.model.database.dao.SalaDao
import com.example.idnplab08.model.database.entity.AutorEntity
import com.example.idnplab08.model.database.entity.PinturaEntity
import com.example.idnplab08.model.database.entity.SalaEntity


@Database(entities = [SalaEntity::class, AutorEntity::class, PinturaEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun salaDao(): SalaDao
    abstract fun autorDao(): AutorDao
    abstract fun pinturaDao(): PinturaDao
    abstract fun descriptionPinturaDao(): DescriptionPinturaDao
    abstract fun pinturaEnSalaDao(): PinturaEnSalaDao
}