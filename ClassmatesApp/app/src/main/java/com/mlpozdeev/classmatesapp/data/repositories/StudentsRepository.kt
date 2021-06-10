package com.mlpozdeev.classmatesapp.data.repositories

import com.mlpozdeev.classmatesapp.data.database.AppDatabase
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity
import com.mlpozdeev.classmatesapp.domain.models.Student
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentsRepository @Inject constructor(private val db: AppDatabase) {

    init {
        generateStudents()
    }

    val students: Observable<List<Student>> = db.studentDao().students
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
            dbStudents.add(
                StudentEntity(
                    firstName = "name$count",
                    lastName = "lastName$count",
                    patronymic = "patronymic$count",
                    groupName = "group${count / 5}"
                )
            )
            count++
        }
        db.runInTransaction {
            db.studentDao().deleteAll()
            db.studentDao().insertAll(dbStudents)
        }
    }

    companion object {
        private const val STUDENTS_COUNT = 20
    }
}