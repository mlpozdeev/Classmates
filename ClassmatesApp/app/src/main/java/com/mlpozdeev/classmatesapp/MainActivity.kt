package com.mlpozdeev.classmatesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mlpozdeev.classmatesapp.data.repositories.StudentsRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //todo просто проверка работы dagger, необходимо убрать
    @Inject lateinit var repository: StudentsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}