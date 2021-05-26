package com.mlpozdeev.classmatesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mlpozdeev.classmatesapp.data.database.entities.StudentEntity
import com.mlpozdeev.classmatesapp.data.repositories.StudentsRepository
import com.mlpozdeev.classmatesapp.domain.interactors.StudentsInteractor
import com.mlpozdeev.classmatesapp.domain.models.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//viewmodel для теста
//todo создать Feature
@HiltViewModel
class MainViewModel @Inject constructor(private val interactor: StudentsInteractor) : ViewModel() {

    val students: LiveData<List<Student>> = interactor.students
        .asLiveData(viewModelScope.coroutineContext)

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            interactor.deleteStudents()
            delay(1000)
            interactor.insertStudent(Student(
                firstName ="Max",
                lastName = "Pozdeev",
                patronymic = "L'vovich",
                groupName = "group"
            ))
            delay(1000)
            interactor.insertStudent(Student(
                firstName ="Max1",
                lastName = "Pozdeev",
                patronymic = "L'vovich",
                groupName = "group"
            ))
            delay(1000)
            interactor.insertStudent(Student(
                firstName ="Max2",
                lastName = "Pozdeev",
                patronymic = "L'vovich",
                groupName = "group"
            ))
            delay(1000)
            interactor.insertStudent(Student(
                firstName ="Max3",
                lastName = "Pozdeev",
                patronymic = "L'vovich",
                groupName = "group"
            ))
            delay(1000)
            interactor.insertStudent(Student(
                firstName ="Max4",
                lastName = "Pozdeev",
                patronymic = "L'vovich",
                groupName = "group"
            ))
            delay(1000)
            interactor.insertStudent(Student(
                firstName ="Max5",
                lastName = "Pozdeev",
                patronymic = "L'vovich",
                groupName = "group"
            ))
        }
    }
}