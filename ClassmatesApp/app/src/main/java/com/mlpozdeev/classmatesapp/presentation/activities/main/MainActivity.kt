package com.mlpozdeev.classmatesapp.presentation.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mlpozdeev.classmatesapp.ClassMatesApp
import com.mlpozdeev.classmatesapp.R
import com.mlpozdeev.classmatesapp.presentation.features.StudentsFeature
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}