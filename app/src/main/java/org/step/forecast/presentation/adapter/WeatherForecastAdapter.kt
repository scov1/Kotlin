package org.step.forecast.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.step.forecast.R
import org.step.forecast.data.api.Api
import org.step.forecast.data.model.WeatherForecastResult

class WeatherForecastAdapter(context: Context,weatherForecastResult: WeatherForecastResult) : RecyclerView.Adapter<WeatherForecastAdapter.MyViewHolder>() {

    var context : Context? = null
    var weatherForecastResult : WeatherForecastResult? = null

//    fun WeatherForecastAdapter(){
//        this.context= context
//        this.weatherForecastResult=weatherForecastResult
//    }



    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

         val txtDate: TextView = itemView.findViewById(R.id.textView_fragment_item_date)
         val txtDesc: TextView = itemView.findViewById(R.id.textView_fragment_item_desc)
         val itemImg: ImageView = itemView.findViewById(R.id.imageView_fragment_today_img)
         val txtTemp : TextView = itemView.findViewById(R.id.textView_fragment_today_temp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView : View = LayoutInflater.from(context).inflate(
            R.layout.fragment_item,
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Picasso.get().load(
            StringBuilder("https://openweathermap.org/img/w/")
                .append(weatherForecastResult?.list?.get(position)?.weather?.get(0)?.getIcon())
                .append(".png").toString()
        ).into(holder.itemImg)

        holder.txtDate.text = weatherForecastResult?.list?.get(position)?.dt?.toLong()?.let {
            Api.convertUnixToDate(
                it
            )
        }

        holder.txtDesc.text = weatherForecastResult?.list?.get(position)?.weather?.get(0)?.getDesc()

        holder.txtTemp.text = StringBuilder(
            weatherForecastResult?.list?.get(position)?.main?.getTemp().toString()
        ).append("°C").toString()



        Log.d("testHolder", "Viewholder test")
    }



    override fun getItemCount(): Int {
        return weatherForecastResult?.list?.size ?: 0
    }



}