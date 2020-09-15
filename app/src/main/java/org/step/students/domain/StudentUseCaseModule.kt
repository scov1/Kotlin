package org.step.students.domain

import dagger.Provides

class StudentUseCaseModule {

    @Provides
    fun providesStudentsUtilsUseCase(): StudentUtilsUseCase {
        return StudentUtilsUseCase()
    }

}