package org.step.students.presentation.interfaces

import io.reactivex.Observable
import org.step.students.data.Currency
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("latest")
    fun currencies(): Call<Currency>

    @GET("latest")
    fun currencies(@Query("base") base: String): Call<Currency>

    @GET("latest")
    fun initiateGetCurrencies(): Observable<Response<Currency>>
}