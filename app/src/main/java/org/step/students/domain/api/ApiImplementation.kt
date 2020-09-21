package org.step.students.domain.api


import io.reactivex.Observable
import org.step.students.data.Currency
import org.step.students.presentation.interfaces.ApiInterface
import retrofit2.Call
import retrofit2.Response

class ApiImplementation : ApiInterface {

    var api: ApiInterface

    constructor() {
        api = Api().initializeAPI()
    }

    override fun currencies(): Call<Currency> {
        return api.currencies()
    }

    override fun currencies(base: String): Call<Currency> {
        return api.currencies(base)
    }

    override fun initiateGetCurrencies(): Observable<Response<Currency>> {
        return api.initiateGetCurrencies()
    }
}