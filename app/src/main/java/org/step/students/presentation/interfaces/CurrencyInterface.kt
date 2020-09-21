package org.step.students.presentation.interfaces

import io.reactivex.Observable
import org.step.students.data.Currency


interface CurrencyInterface {
    fun initiateGetCurrency(): Observable<Currency>

}