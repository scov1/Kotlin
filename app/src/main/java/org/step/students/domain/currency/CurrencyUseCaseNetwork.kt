package org.step.students.domain.currency

import io.reactivex.Observable
import org.step.students.base.BaseNetwork
import org.step.students.data.Currency
import org.step.students.data.database.CurrencyRepository
import org.step.students.presentation.interfaces.CurrencyInterface

class CurrencyUseCaseNetwork : BaseNetwork<Currency> {
    var currencyDomainRepository: CurrencyInterface

    constructor() {
        currencyDomainRepository = CurrencyRepository()
    }

    override fun initiateCreateObservable(): Observable<Currency> {
        return currencyDomainRepository.initiateGetCurrency()
    }
}