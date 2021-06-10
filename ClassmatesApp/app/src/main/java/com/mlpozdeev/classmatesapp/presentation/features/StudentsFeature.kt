package com.mlpozdeev.classmatesapp.presentation.features

import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import com.mlpozdeev.classmatesapp.domain.interactors.StudentsInteractor
import com.mlpozdeev.classmatesapp.domain.models.Student
import com.mlpozdeev.classmatesapp.presentation.features.StudentsFeature.*
import com.mlpozdeev.classmatesapp.presentation.features.StudentsFeature.Wish.*
import com.mlpozdeev.classmatesapp.presentation.features.StudentsFeature.Effect.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StudentsFeature @Inject constructor(
    interactor: StudentsInteractor
) : ActorReducerFeature<Wish, Effect, State, Nothing>(
    initialState = State(),
    reducer = ReducerImpl(),
    actor = ActorImpl(interactor)
) {

    data class State(
        val students: List<Student> = listOf()
    )

    sealed class Wish {
        object LoadNewData : Wish()
    }

    sealed class Effect {
        data class LoadedData(val students: List<Student>) : Effect()
    }

    class ActorImpl(private val interactor: StudentsInteractor) : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<out Effect> = when(wish) {
            is LoadNewData -> {
                interactor.students
                    .subscribeOn(Schedulers.io())
                    .map {
                        LoadedData(it)
                    }
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State = when(effect) {
            is LoadedData -> state.copy(
                students = effect.students
            )
        }
    }
}