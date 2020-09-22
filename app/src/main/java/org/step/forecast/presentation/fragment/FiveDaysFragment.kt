package org.step.forecast.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.step.forecast.R
import org.step.forecast.data.api.Api.Companion.API_ID
import org.step.forecast.data.api.Api.Companion.current_location
import org.step.forecast.data.model.WeatherForecastResult
import org.step.forecast.data.retrofit.RetrofitClient
import org.step.forecast.presentation.adapter.WeatherForecastAdapter
import org.step.forecast.presentation.interfaces.IWeather
import retrofit2.Retrofit


class FiveDaysFragment : Fragment() {


    var instance: FiveDaysFragment? = null
    private var compositeDisposable : CompositeDisposable? = null
    private var mService : IWeather? = null
    private var daysCityName : TextView? = null
    private var daysCoord : TextView? = null
    private var recyclerForecast : RecyclerView? = null
    private var rootView : View? = null

    companion object {

        fun getInstance(): FiveDaysFragment {

            return FiveDaysFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView= inflater.inflate(R.layout.fragment_five_days, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        compositeDisposable= CompositeDisposable()
        var retrofit : Retrofit? = RetrofitClient.getInstance()
        mService = retrofit!!.create(IWeather::class.java)

        initializeViews()

        getForecastWeatherInfo()

    }


    fun initializeViews(){
        daysCityName = rootView?.findViewById(R.id.textView_fragment_five_days_city_name)
        daysCoord = rootView?.findViewById(R.id.textView_fragment_five_days_coord)
        recyclerForecast = rootView?.findViewById(R.id.recyclerView_fragment_five_days_forecast)
        recyclerForecast?.setHasFixedSize(true)
        recyclerForecast!!.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    override fun onStop() {
        compositeDisposable?.clear()
        super.onStop()
    }

    private fun getForecastWeatherInfo() {
        compositeDisposable!!.add(
            mService!!.getForecastWeatherLatLon(
                current_location!!.latitude.toString(), current_location!!.longitude.toString(),
                API_ID,
                "metric"
            )
                !!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { weatherForecastResult ->
                    displayForecastWeather(
                        weatherForecastResult
                    )
                },
                    { throwable -> Log.d("ERROR", throwable.message!!) })
        )
    }

    private fun displayForecastWeather(weatherForecastResult: WeatherForecastResult?) {
        daysCityName!!.text = StringBuilder(weatherForecastResult?.city?.name)
        daysCoord!!.text=StringBuilder(weatherForecastResult?.city?.coord.toString())
        val adapter = WeatherForecastAdapter(context!!, weatherForecastResult!!)
        recyclerForecast!!.adapter = adapter
    }

}