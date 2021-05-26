package com.mlpozdeev.classmatesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @get:Query("SELECT * FROM student")
    val students: Flow<List<StudentEntity>>

    @Insert
    suspend fun insertStudent(student: StudentEntity)

    @Query("DELETE FROM student")
    suspend fun deleteAll()
}