package org.step.forecast.data.model

class Coord {
    private var lon : Double = 0.0
    private var lat : Double = 0.0

    fun Coord(){}


    fun getLon(): Double? {
        return lon
    }

    fun setLon(lon: Double?) {
        if (lon != null) {
            this.lon = lon
        }
    }

    fun getLat(): Double? {
        return lat
    }

    fun setLat(lat: Double?) {
        if (lat != null) {
            this.lat = lat
        }
    }


    override fun toString(): String {
        return StringBuilder("[").append(lat).append(',').append(lon).append(']').toString()
    }
}