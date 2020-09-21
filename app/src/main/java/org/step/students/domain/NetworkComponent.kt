package org.step.students.domain

import dagger.Component
import org.step.students.presentation.fragment.CurrencyFragmentPresenter

@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {
    fun inject(currenciesFragmentPresenter: CurrencyFragmentPresenter)
}