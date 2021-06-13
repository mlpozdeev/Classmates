package com.mlpozdeev.classmatesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface StudentDao {
    @get:Query("SELECT * FROM student")
    val students: Flowable<List<StudentEntity>>

    @Insert
    fun insertStudent(student: StudentEntity): Completable

    @Insert
    fun insertAll(students: List<StudentEntity>): Completable

    @Query("DELETE FROM student")
    fun deleteAll(): Completable
}