package com.mlpozdeev.classmatesapp.data.repositories

import com.mlpozdeev.classmatesapp.data.database.AppDatabase
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity
import com.mlpozdeev.classmatesapp.domain.models.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StudentsRepository @Inject constructor(private val db: AppDatabase) {

    val students = db.studentDao().students
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
        .flowOn(Dispatchers.Default)

    suspend fun insertStudent(student: Student) {
        db.studentDao().insertStudent(mapStudentToDbStudent(student))
    }

    suspend fun deleteStudents() {
        db.studentDao().deleteAll()
    }

    private fun mapStudentToDbStudent(student: Student): StudentEntity {
        return StudentEntity(
            student.firstName,
            student.lastName,
            student.patronymic,
            student.groupName
        )
    }
}