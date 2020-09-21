package org.step.forecast.data.model

class Main {
    private var temp = 0.0
    private var feels_like = 0.0
    private var temp_min = 0.0
    private var temp_max = 0.0
    private var pressure = 0
    private var humidity = 0

    fun Main(){}


    fun getTemp(): Double? {
        return temp
    }

    fun setTemp(temp : Double?) {
        if (temp != null) {
            this.temp = temp
        }
    }


    fun getFeelsLike(): Double? {
        return feels_like
    }

    fun setFeelsLike(feels_like : Double?) {
        if (feels_like != null) {
            this.feels_like = feels_like
        }
    }


    fun getTempMin(): Double? {
        return temp_min
    }

    fun setTempMin(temp_min : Double?) {
        if (temp_min != null) {
            this.temp_min = temp_min
        }
    }

    fun getTempMax(): Double? {
        return temp_max
    }

    fun setTempMax(temp_max : Double?) {
        if (temp_max != null) {
            this.temp_max = temp_max
        }
    }

    fun getPressure(): Int? {
        return pressure
    }

    fun setPressure(pressure : Int?) {
        if (pressure != null) {
            this.pressure = pressure
        }
    }

    fun getHumidity(): Int? {
        return humidity
    }

    fun setHumidity(humidity : Int?) {
        if (humidity != null) {
            this.humidity = humidity
        }
    }


}
