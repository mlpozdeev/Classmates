package com.mlpozdeev.classmatesapp.data.repositories

import android.util.Log
import com.mlpozdeev.classmatesapp.data.database.AppDatabase
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity
import com.mlpozdeev.classmatesapp.domain.models.Student
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentsRepository @Inject constructor(private val db: AppDatabase) {

    init {
        Completable.fromCallable { generateStudents() }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    val students: Single<List<Student>> = db.studentDao().students
        .map {
            val students = mutableListOf<Student>()
            it.forEach { dbStudent ->
                val student = Student(
                    dbStudent.firstName,
                    dbStudent.lastName,
                    dbStudent.patronymic,
                    dbStudent.groupName,
                    dbStudent.id
                )
                students.add(student)
            }

            return@map students
        }

    private fun generateStudents() {
        val dbStudents = mutableListOf<StudentEntity>()
        var count = 0
        while (count < STUDENTS_COUNT) {
            val student = StudentEntity(
                firstName = "name$count",
                lastName = "lastName$count",
                patronymic = "patronymic$count",
                groupName = "group${count / 5}"
            )
            dbStudents.add(student)
            Log.d(TAG, student.firstName)
            count++
        }
        db.runInTransaction {
            db.studentDao().apply {
                deleteAll()
                    .subscribe {
                        Log.d(TAG, "delete success")
                    }
                insertAll(dbStudents)
                    .subscribe {
                        Log.d(TAG, "insert success")
                    }
            }
        }
    }

    companion object {
        private const val STUDENTS_COUNT = 20
        private const val TAG = "StudentsRepository"
    }
}