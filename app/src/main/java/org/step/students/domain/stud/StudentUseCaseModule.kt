package org.step.students.domain.stud

import dagger.Provides

class StudentUseCaseModule {

    @Provides
    fun providesStudentsUtilsUseCase(): StudentUtilsUseCase {
        return StudentUtilsUseCase()
    }

}