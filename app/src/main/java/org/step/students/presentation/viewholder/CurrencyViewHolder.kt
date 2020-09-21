package org.step.students.presentation.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_currency.view.*
import org.step.students.domain.currency.Currency

class CurrencyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    var context: Context? = null

    fun initiateBind(currency: Currency) {
        itemView.textView_viewHolder_currency_title?.setText(currency.title)
        itemView.textView_viewHolder_currency_rate?.setText(currency.rate.toString())
    }
}