package com.mlpozdeev.classmatesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mlpozdeev.classmatesapp.data.database.entities.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM student")
    suspend fun getStudents(): List<Student>

    @Insert
    suspend fun insertStudent(student: Student)
}