package com.mlpozdeev.classmatesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mlpozdeev.classmatesapp.data.database.dao.StudentDao
import com.mlpozdeev.classmatesapp.data.database.entities.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "classmates-db"
    }

    abstract fun studentDao(): StudentDao
}