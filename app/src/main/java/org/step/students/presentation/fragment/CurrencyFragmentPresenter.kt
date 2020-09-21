package org.step.students.presentation.fragment

import org.step.students.domain.currency.CurrencyUseCase
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_currency.*
import org.step.students.data.Currency
import org.step.students.presentation.interfaces.CurrencyInterfaceContract
import org.step.students.domain.api.Api
import org.step.students.domain.api.ApiImplementation
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.inject.Inject


class CurrencyFragmentPresenter() :  CurrencyInterfaceContract.Presenter, Parcelable {
    var view: CurrencyInterfaceContract.View? = null
    var context: Context? = null
    var currencies: ArrayList<org.step.students.domain.currency.Currency> = ArrayList()
    //@Inject lateinit var currenciesUseCase: CurrenciesUseCase
    var currenciesUseCase: CurrencyUseCase = CurrencyUseCase()
    @Inject
    lateinit var api: ApiImplementation

    constructor(parcel: Parcel) : this() {

    }

    constructor(context: Context) : this() {
        this.context = context
        // dagger
        //DaggerCurrencyComponent.builder().currencyModule(CurrencyModule()).build().inject(this)
        //Log.d("DEBUG_CURRENCY", "Presenter: after dagger - $currenciesUseCase")
    }

    override fun initializeData() {
//        view?.processData(currencies)
//        view?.initiateUpdateAdapter()

        val call = Api().initializeAPI().currencies()
        call.enqueue(object : retrofit2.Callback<org.step.students.data.Currency> {
            override fun onFailure(call: Call<Currency>, t: Throwable) {
                Toast.makeText(context, "Can't get currency", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Currency>,
                response: Response<Currency>
            ) {
                (view as Fragment).textView_fragment_currencies_base_currency.setText(response.body()?.getBase())
                initiateCurrencyToCurrenciesArray(response.body()!!)
            }
        })

    }



    override fun initiateCurrencyToCurrenciesArray(currency: Currency) {
        currencies = currenciesUseCase.initiateCurrencyToCurrenciesArray(currency)
        view?.processData(currencies)
        view?.initiateUpdateAdapter()
    }


    override fun attach(view: CurrencyInterfaceContract.View) {
        this.view = view
    }

    override fun onStop() {
        view = null
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurrencyFragmentPresenter> {
        override fun createFromParcel(parcel: Parcel): CurrencyFragmentPresenter {
            return CurrencyFragmentPresenter(parcel)
        }

        override fun newArray(size: Int): Array<CurrencyFragmentPresenter?> {
            return arrayOfNulls(size)
        }
    }
}