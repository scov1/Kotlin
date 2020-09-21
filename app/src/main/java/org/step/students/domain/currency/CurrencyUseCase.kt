package org.step.students.domain.currency

import org.step.students.data.Currency

class CurrencyUseCase {

    fun initiateCurrencyToCurrenciesArray(currency: Currency): ArrayList<org.step.students.domain.currency.Currency> {
        val currencies: ArrayList<org.step.students.domain.currency.Currency> = ArrayList()

        currencies.add(Currency("CAD", currency.getRates()?.cad!!))
        currencies.add(Currency("HKD", currency.getRates()?.hkd!!))
        currencies.add(Currency("ISK", currency.getRates()?.isk!!))
        currencies.add(Currency("PHP", currency.getRates()?.php!!))
        currencies.add(Currency("DKK", currency.getRates()?.dkk!!))
        currencies.add(Currency("HUF", currency.getRates()?.huf!!))
        currencies.add(Currency("CZK", currency.getRates()?.czk!!))
        currencies.add(Currency("AUD", currency.getRates()?.aud!!))
        currencies.add(Currency("RON", currency.getRates()?.ron!!))
        currencies.add(Currency("SEK", currency.getRates()?.sek!!))
        currencies.add(Currency("IDR", currency.getRates()?.idr!!))
        currencies.add(Currency("INR", currency.getRates()?.inr!!))
        currencies.add(Currency("BRL", currency.getRates()?.brl!!))
        currencies.add(Currency("RUB", currency.getRates()?.rub!!))
        currencies.add(Currency("HRK", currency.getRates()?.hrk!!))
        currencies.add(Currency("JPY", currency.getRates()?.jpy!!))
        currencies.add(Currency("THB", currency.getRates()?.thb!!))
        currencies.add(Currency("CHF", currency.getRates()?.chf!!))
        currencies.add(Currency("SGD", currency.getRates()?.sgd!!))
        currencies.add(Currency("PLN", currency.getRates()?.pln!!))
        currencies.add(Currency("BGN", currency.getRates()?.bgn!!))
        currencies.add(Currency("TRY", currency.getRates()?.`try`!!))
        currencies.add(Currency("CNY", currency.getRates()?.cny!!))
        currencies.add(Currency("NOK", currency.getRates()?.nok!!))
        currencies.add(Currency("NZD", currency.getRates()?.nzd!!))
        currencies.add(Currency("ZAR", currency.getRates()?.zar!!))
        currencies.add(Currency("USD", currency.getRates()?.usd!!))
        currencies.add(Currency("MXN", currency.getRates()?.mxn!!))
        currencies.add(Currency("ILS", currency.getRates()?.ils!!))
        currencies.add(Currency("GBP", currency.getRates()?.gbp!!))
        currencies.add(Currency("KRW", currency.getRates()?.krw!!))
        currencies.add(Currency("MYR", currency.getRates()?.myr!!))

        return currencies
    }
}