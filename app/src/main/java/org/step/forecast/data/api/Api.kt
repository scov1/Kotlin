package org.step.forecast.data.api

import android.location.Location
import java.text.SimpleDateFormat
import java.util.*

class Api {

    companion object{
        var  current_location: Location? = null
        val  API_ID = "713d386b8afd23f7b53664049c4744fa"

        fun convertUnixToDate(dt: Long): String? {
            val date = Date(dt * 1000L)
            val sdf = SimpleDateFormat("HH:mm dd EEE MM yyyy")
            return sdf.format(date)
        }

        fun convertUnixToHour(dt: Long): String? {
            val date = Date(dt * 1000L)
            val sdf = SimpleDateFormat("HH:mm")
            return sdf.format(date)
        }

    }


}

