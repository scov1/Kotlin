package org.step.students.domain

import dagger.Component
import org.step.students.presentation.fragment.StudentsFragment


@Component(modules = arrayOf(RepositoryModule::class))
interface RepositoryComponent {
    fun inject(studentsFragment: StudentsFragment)
}
