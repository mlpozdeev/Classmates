package com.mlpozdeev.classmatesapp.presentation.fragments.students.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mlpozdeev.classmatesapp.R
import com.mlpozdeev.classmatesapp.domain.models.Student

class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val studentFullName = view.findViewById<TextView>(R.id.student_full_name)
    private val groupName = view.findViewById<TextView>(R.id.group_name)

    fun bind(student: Student) {
        studentFullName.text = student.firstName
        groupName.text = student.groupName
    }

    companion object {
        fun create(parent: ViewGroup): StudentViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)

            return StudentViewHolder(view)
        }
    }
}