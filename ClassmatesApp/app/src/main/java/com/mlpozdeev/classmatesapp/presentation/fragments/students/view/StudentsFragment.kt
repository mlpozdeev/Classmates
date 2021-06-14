package com.mlpozdeev.classmatesapp.presentation.fragments.students.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mlpozdeev.classmatesapp.ClassMatesApp
import com.mlpozdeev.classmatesapp.dagger.ScreenComponent
import com.mlpozdeev.classmatesapp.dagger.ScreenModule
import com.mlpozdeev.classmatesapp.databinding.FragmentStudentsBinding
import com.mlpozdeev.classmatesapp.presentation.features.students.StudentsBindings
import com.mlpozdeev.classmatesapp.presentation.fragments.students.event.StudentsUiEvent
import com.mlpozdeev.classmatesapp.presentation.fragments.students.viewmodel.StudentsViewModel
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class StudentsFragment : Fragment(), Consumer<StudentsViewModel>,
    ObservableSource<StudentsUiEvent> {

    @Inject lateinit var bindings: StudentsBindings

    private lateinit var screenComponent: ScreenComponent
    private lateinit var adapter: StudentsListAdapter

    private var _binding: FragmentStudentsBinding? = null

    private val binding get() = _binding!!
    private val source = PublishSubject.create<StudentsUiEvent>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        screenComponent = (requireActivity().application as ClassMatesApp).appComponent.screenComponent()
            .screenModule(ScreenModule(viewLifecycleOwner))
            .build()
        screenComponent.inject(this)
        _binding = FragmentStudentsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = StudentsListAdapter()
        binding.studentsList.adapter = adapter

        Log.d(TAG, "start bindings setup")
        bindings.setup(this)
        Log.d(TAG, "end bindings setup")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun accept(viewModel: StudentsViewModel) {
        adapter.submitList(viewModel.students)
        Log.d(TAG, "list submitted")
    }

    override fun subscribe(observer: Observer<in StudentsUiEvent>) {
        source.subscribe(observer)

        source.onNext(StudentsUiEvent.LoadData)
    }

    companion object {
        private const val TAG = "StudentsFragment"
    }
}