package com.mlpozdeev.classmatesapp.presentation.fragments.students

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.badoo.binder.Binder
import com.badoo.mvicore.android.AndroidBinderLifecycle
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.mlpozdeev.classmatesapp.ClassMatesApp
import com.mlpozdeev.classmatesapp.databinding.FragmentStudentsBinding
import com.mlpozdeev.classmatesapp.domain.models.Student
import com.mlpozdeev.classmatesapp.presentation.features.StudentsFeature
import io.reactivex.functions.Consumer

class StudentsFragment : Fragment(), Consumer<StudentsFeature.State> {

    private lateinit var adapter: StudentsListAdapter
    private lateinit var feature: StudentsFeature
    private lateinit var binder: Binder

    private var _binding: FragmentStudentsBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        feature = (requireActivity().application as ClassMatesApp).appComponent.getFeature()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lifecycle = CreateDestroyBinderLifecycle(viewLifecycleOwner.lifecycle)
        binder = Binder(lifecycle).apply { bind(feature to this@StudentsFragment) }

        adapter = StudentsListAdapter()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.studentsList.adapter = adapter
        binding.studentsList.layoutManager = layoutManager
        feature.accept(StudentsFeature.Wish.LoadNewData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun accept(state: StudentsFeature.State) {
        adapter.submitList(state.students)
    }
}