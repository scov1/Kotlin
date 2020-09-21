package org.step.forecast.data.model

class Sys {

    var type = 0
    var id = 0
    var country: String? = null
    var sunrise = 0
    var sunset = 0

    fun Sys(){}

    fun getType() : Int?{
        return type
    }

    fun setType(type : Int?){
        if (type != null) {
            this.type = type
        }
    }


    fun getId(): Int? {
        return id
    }

    fun setId(id : Int?) {
        if (id != null) {
            this.id = id
        }
    }

    fun getCoutry() : String?{
        return country
    }

    fun setCoutry(country : String){
        this.country = country
    }


    fun getSunrise(): Int? {
        return sunrise
    }

    fun setSunrise(sunrise : Int?) {
        if (sunrise != null) {
            this.sunrise = sunrise
        }
    }


    fun getSunset(): Int? {
        return id
    }

    fun setSunset(sunset : Int?) {
        if (sunset != null) {
            this.sunset = sunset
        }
    }


}
