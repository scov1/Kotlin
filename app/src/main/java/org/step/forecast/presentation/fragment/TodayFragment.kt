package org.step.forecast.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.step.forecast.R
import org.step.forecast.data.api.Api.Companion.API_ID
import org.step.forecast.data.api.Api.Companion.current_location
import org.step.forecast.data.retrofit.RetrofitClient
import org.step.forecast.presentation.interfaces.IWeather
import retrofit2.Retrofit


class TodayFragment : Fragment() {

    private var rootView : View? = null
    private var img_weather : ImageView? = null
    private var city_name : TextView? = null
    private var today_temp : TextView? = null
    private var today_desc : TextView? = null
    private var today_date_time : TextView? = null
    private var today_wind : TextView? = null
    private var today_pressure : TextView? = null
    private var today_humidity : TextView? = null
    private var today_sunrise : TextView? = null
    private var today_sunset : TextView? = null
    private var today_coord : TextView? = null
    private var today_weather_menu : LinearLayout? = null
    private var today_loading : ProgressBar? = null
    private var compositeDisposable : CompositeDisposable? = null
    private var mService : IWeather? = null
    var instance: TodayFragment? = null


    companion object {

        fun getInstance(): TodayFragment {

            return TodayFragment()
        }
    }

//    companion object{
//
//        fun getInstance(): TodayFragment? {
//            if (TodayFragment().instance == null) TodayFragment().instance = TodayFragment()
//            return TodayFragment().instance
//        }
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        compositeDisposable= CompositeDisposable()
        var retrofit : Retrofit? = RetrofitClient.getInstance()
        mService = retrofit!!.create(IWeather::class.java)

        initializeViews()

        getWeatherInfo()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_today, container, false)
        return rootView
    }


    fun initializeViews(){



        img_weather =rootView?.findViewById(R.id.imageView_fragment_today_img)
        city_name = rootView?.findViewById(R.id.textView_fragment_today_city_name)
        today_temp = rootView?.findViewById(R.id.textView_fragment_today_temp)
        today_desc = rootView?.findViewById(R.id.textView_fragment_today_desc)
        today_date_time = rootView?.findViewById(R.id.textView_fragment_today_date_time)
        today_wind = rootView?.findViewById(R.id.textView_fragment_today_wind)
        today_pressure = rootView?.findViewById(R.id.textView_fragment_today_pressure)
        today_humidity = rootView?.findViewById(R.id.textView_fragment_today_humidity)
        today_sunrise = rootView?.findViewById(R.id.textView_fragment_today_sunrise)
        today_sunset = rootView?.findViewById(R.id.textView_fragment_today_sunset)
        today_coord = rootView?.findViewById(R.id.textView_fragment_today_coord)
        city_name = rootView?.findViewById(R.id.textView_fragment_today_city_name)
        today_weather_menu = rootView?.findViewById(R.id.linearLayout_fragment_today_menu)
        today_loading = rootView?.findViewById(R.id.progressBar_fragment_today_loading)


    }


    private fun getWeatherInfo() {
        compositeDisposable!!.add(
            mService!!.getWeatherLatLon(
                current_location!!.latitude.toString(),
                current_location!!.longitude.toString(),
                API_ID,
                "metric"
            )
            !!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { weatherResult ->
//                        Picasso.get().load(
//                            StringBuilder("https://openweathermap.org/img/wn/")
//                                .append(weatherResult?.getWeather()!![0].getIcon())
//                                .append(".png").toString()
//                        ).into(img_weather)
//                        city_name!!.text = weatherResult?.getName()
//                        today_desc!!.text = StringBuilder("Weather in")
//                            .append(weatherResult?.getName()).toString()
//                        today_temp!!.text =
//                            StringBuilder(
//                                weatherResult?.getMain()!!.getTemp().toString()
//                            ).append("C").toString()
//                        today_date_time!!.text = convertUnixToDate(
//                            weatherResult.getDt()!!.toLong()
//                        )
//                        today_pressure!!.text =
//                            StringBuilder(
//                                weatherResult.getMain()!!.getPressure().toString()
//                            ).append("hpa").toString()
//                        today_humidity!!.text =
//                            StringBuilder(
//                                weatherResult.getMain()!!.getHumidity().toString()
//                            ).append("%").toString()
//                        today_sunrise!!.text =
//                            weatherResult.getSys()!!.getSunrise()?.toLong()?.let {
//                                convertUnixToHour(
//                                    it
//                                )
//                            }
//                        today_sunset!!.text = weatherResult.getSys()!!.getSunset()?.toLong()?.let {
//                            convertUnixToHour(
//                                it
//                            )
//                        }
//                        today_coord!!.text =
//                            StringBuilder("[").append(weatherResult.getCoord().toString())
//                                .append("]").toString()
//                        today_weather_menu!!.visibility = View.VISIBLE
//                        today_loading!!.visibility = View.GONE

                        Log.d("test",weatherResult.toString())
                    },
                    { throwable ->
                        Log.d("test",throwable.message.toString())
                        Toast.makeText(
                            activity,
                            "" + throwable.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    })
        )
    }
}