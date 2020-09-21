package org.step.students.domain.currency

import dagger.Component
import org.step.students.presentation.adapter.CurrencyAdapter
import org.step.students.presentation.fragment.CurrencyFragment
import org.step.students.presentation.interfaces.CurrencyInterfaceContract


@Component(modules = arrayOf(CurrencyModule::class))
interface CurrencyComponent {

    fun inject(fragment: CurrencyFragment)

    fun inject(currenciesFragmentPresenter: CurrencyInterfaceContract.Presenter)

    fun inject(currencyAdapter: CurrencyAdapter)
}