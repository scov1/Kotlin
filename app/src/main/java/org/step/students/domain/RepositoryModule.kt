package org.step.students.domain

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.Provides
import org.step.students.domain.stud.StudentUtilsUseCase


class RepositoryModule {

    @Provides
    fun providesContext( fragment: Fragment): Context {
        return fragment.context!!
    }

    @Provides
    fun providesStudentsUtilsUseCase(): StudentUtilsUseCase {
        return StudentUtilsUseCase()
    }

}