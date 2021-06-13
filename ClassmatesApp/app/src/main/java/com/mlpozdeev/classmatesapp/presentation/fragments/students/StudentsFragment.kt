package com.mlpozdeev.classmatesapp.presentation.fragments.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlpozdeev.classmatesapp.databinding.FragmentStudentsBinding
import com.mlpozdeev.classmatesapp.domain.models.Student

class StudentsFragment : Fragment() {

    private var _binding: FragmentStudentsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = StudentsListAdapter()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.studentsList.adapter = adapter
        binding.studentsList.layoutManager = layoutManager

        val testList = mutableListOf(
            Student(
                id = 0,
                firstName = "firstName",
                lastName = "lastName",
                patronymic = null,
                groupName = "group"
            )
        )
        adapter.submitList(testList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}