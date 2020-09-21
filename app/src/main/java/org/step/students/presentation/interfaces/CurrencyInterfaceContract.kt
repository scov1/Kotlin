package org.step.students.presentation.interfaces

import org.step.students.base.BaseContract
import org.step.students.domain.currency.Currency

interface CurrencyInterfaceContract {

    interface View: BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(currencies: ArrayList<Currency>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateCurrencyToCurrenciesArray(currency: org.step.students.data.Currency)
    }
}