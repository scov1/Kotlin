package org.step.forecast.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.label305.asynctask.SimpleAsyncTask
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mancj.materialsearchbar.MaterialSearchBar.OnSearchActionListener
import io.reactivex.disposables.CompositeDisposable
import org.step.forecast.R
import org.step.forecast.data.retrofit.RetrofitClient
import org.step.forecast.presentation.interfaces.IWeather
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import java.util.zip.GZIPInputStream


class CityFragment : Fragment() {

     val listCites: List<String>? = null
     var searchBar: MaterialSearchBar? = null
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
    var instance: CityFragment? = null


    companion object {

        fun getInstance(): CityFragment {

            return CityFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_city, container, false)
        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        compositeDisposable= CompositeDisposable()
        var retrofit : Retrofit? = RetrofitClient.getInstance()
        mService = retrofit!!.create(IWeather::class.java)

//        initializeView()
//
//        getWeatherInfo()
    }

    fun initializeView(){


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

        searchBar = rootView?.findViewById(R.id.material_fragment_city_search)
        searchBar!!.isEnabled = false
       // LoadCities().execute()


    }

//   private  class LoadCities() : SimpleAsyncTask<List<String>>() {
//         val listCites: List<String>? = null
//         var searchBar: MaterialSearchBar? = null
//        override fun doInBackgroundSimple(): List<String> {
//            listCites = ArrayList<String>()
//
//            try {
//
//                val builder = StringBuilder()
//                val `is`: InputStream = context.getResources().openRawResource(R.raw.city_list)
//                val gzipInputStream = GZIPInputStream(`is`)
//                val reader = InputStreamReader(gzipInputStream)
//                val `in` = BufferedReader(reader)
//                var readed: String?
//                while (`in`.readLine().also { readed = it } != null) builder.append(readed)
//                listCites = Gson().fromJson<List<String>>(
//                    builder.toString(),
//                    object : TypeToken<List<String?>?>() {}.type
//                )
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//            return listCites
//        }
//
//        override fun onSuccess(listCity: List<String>) {
//            super.onSuccess(listCity)
//            searchBar.setEnabled(true)
//            searchBar.addTextChangeListener(object : TextWatcher {
//                override fun beforeTextChanged(
//                    charSequence: CharSequence,
//                    i: Int,
//                    i1: Int,
//                    i2: Int
//                ) {
//                }
//
//                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                    val suggest: MutableList<String> = ArrayList()
//                    for (search in listCity) {
//                        if (search.toLowerCase()
//                                .contains(searchBar.getText().toLowerCase())
//                        ) suggest.add(search)
//                    }
//                    searchBar.setLastSuggestions(suggest)
//                }
//
//                override fun afterTextChanged(editable: Editable) {}
//            })
//            searchBar.setOnSearchActionListener(object : OnSearchActionListener {
//                override fun onSearchStateChanged(enabled: Boolean) {}
//                override fun onSearchConfirmed(text: CharSequence) {
//                    getWeatherInfo(text.toString())
//                    searchBar.setLastSuggestions(listCity)
//                }
//
//                override fun onButtonClicked(buttonCode: Int) {}
//            })
//        }
//
//        private fun getWeatherInfo(toString: String) {
//
//        }
//    }


}


