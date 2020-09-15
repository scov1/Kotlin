package org.step.students.domain

import dagger.Component
import org.step.students.presentation.fragment.StudentsFragment


@Component(modules = arrayOf(StudnetUseCaseModule::class))
interface StudentUseCaseComponent {

    fun initiateReturnStudentsUseCase(): StudentUtilsUseCase
    fun inject(studentsFragment: StudentsFragment)

}