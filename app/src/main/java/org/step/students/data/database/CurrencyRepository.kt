package org.step.students.data.database

import io.reactivex.Observable
import org.step.students.data.Currency
import org.step.students.domain.api.ApiImplementation
import org.step.students.presentation.interfaces.CurrencyInterface

class CurrencyRepository : CurrencyInterface {
    var apiImplementation: ApiImplementation

    constructor() {
        apiImplementation = ApiImplementation()
    }

    override fun initiateGetCurrency(): Observable<Currency> {
        return apiImplementation.initiateGetCurrencies()
            .map{ response ->
                (if(response.isSuccessful) {
                    response.body()
                } else {
                    throw Exception()
                })!!
            }
    }
}