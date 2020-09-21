package org.step.forecast.data.model

import android.opengl.Visibility
import java.util.*

class WeatherResult {
    private var coord: Coord? = null
    private var weather: List<Weather>? = null
    private var base: String? = null
    private var main: Main? = null
    private var visibility = 0
    private var wind: Wind? = null
    private var clouds: Clouds? = null
    private var dt = 0
    private var sys: Sys? = null
    private var timezone = 0
    private var id = 0
    private var name: String? = null
    private var cod = 0


    fun WeatherResult() {}


    fun getCoord(): Coord? {
        return coord
    }


    fun setCoord(coord : Coord) {
        this.coord = coord
    }

    fun getWeather(): List<Weather>? {
        return weather
    }


    fun setWeather(weather: List<Weather>) {
        this.weather = weather
    }

    fun getBase(): String?{
        return base
    }


    fun setBase(base : String?){
        this.base = base
    }

    fun getMain() : Main?{
        return main
    }

    fun setMain(main : Main){
        this.main=main
    }

    fun getVisability() : Int?{
        return visibility
    }

    fun setVisability(visibility : Int){
        this.visibility=visibility
    }

    fun getWind() : Wind?{
        return wind
    }

    fun setWind(wind : Wind){
        this.wind=wind
    }

    fun getClounds() : Clouds?{
        return clouds
    }

    fun setClouds(clouds : Clouds){
        this.clouds=clouds
    }

    fun getDt() : Int?{
        return dt
    }

    fun setDt(dt : Int){
        this.dt=dt
    }

    fun getSys() : Sys?{
        return sys
    }

    fun setSys(sys : Sys){
        this.sys=sys
    }

    fun getTimezone() : Int?{
        return timezone
    }

    fun setTimezone(timezone : Int){
        this.timezone=timezone
    }

    fun getId() : Int?{
        return id
    }

    fun setId(id : Int){
        this.id=id
    }

    fun getName() : String?{
        return name
    }

    fun setName(name : String){
        this.name=name
    }

    fun getCod() : Int?{
        return cod
    }

    fun setCod(cod : Int){
        this.cod=cod
    }
}