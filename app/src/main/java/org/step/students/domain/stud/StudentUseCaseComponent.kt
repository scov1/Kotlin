package org.step.students.domain.stud

import dagger.Component
import org.step.students.presentation.fragment.StudentsFragment


@Component(modules = arrayOf(StudentUseCaseModule::class))
interface StudentUseCaseComponent {

    fun initiateReturnStudentsUseCase(): StudentUtilsUseCase
    fun inject(studentsFragment: StudentsFragment)

}