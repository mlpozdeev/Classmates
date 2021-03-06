package com.mlpozdeev.classmatesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mlpozdeev.classmatesapp.data.database.dao.StudentDao
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity

@Database(entities = [StudentEntity::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        const val DB_NAME = "classmates-db"
    }
}