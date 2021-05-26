package com.mlpozdeev.classmatesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.test_tv)
        viewModel.students.observe(this) {
            if (it.isNotEmpty()) {
                val s = it[it.lastIndex]
                tv.text = "${s.id}"
            }
        }
    }
}