package org.step.students.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_currency.*
import org.step.students.R
import org.step.students.data.Currency
import org.step.students.domain.api.Api
import org.step.students.presentation.fragment.CurrencyFragmentPresenter
import org.step.students.presentation.viewholder.CurrencyViewHolder
import retrofit2.Call
import retrofit2.Response


class CurrencyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context? = null
    var currencies: ArrayList<org.step.students.domain.currency.Currency> = ArrayList()
    var presenter: CurrencyFragmentPresenter? = null

    constructor(context: Context, currencies: ArrayList<org.step.students.domain.currency.Currency>, presenter: CurrencyFragmentPresenter) {
        this.context = context
        this.currencies = currencies
        this.presenter = presenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context!!).inflate(R.layout.viewholder_currency, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val call = Api().initializeAPI().currencies(currencies[position].title)
            call.enqueue(object : retrofit2.Callback<Currency> {
                override fun onFailure(call: Call<Currency>, t: Throwable) {
                    Log.e("retrofit", "get retrofit")
                }

                override fun onResponse(call: Call<Currency>, response: Response<Currency>) {
                    presenter?.initiateCurrencyToCurrenciesArray(response.body()!!)
                    (presenter?.view as Fragment).textView_fragment_currencies_base_currency.setText(currencies[position].title)
                }
            })
        }

        (holder as CurrencyViewHolder).initiateBind(currencies.get(position))
    }
}
