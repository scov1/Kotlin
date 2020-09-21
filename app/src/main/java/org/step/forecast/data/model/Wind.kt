package org.step.forecast.data.model

class Wind {

    var speed = 0.0
    var deg = 0


    fun Wind(){}


    fun getSpeed(): Double? {
        return speed
    }

    fun setSpeed(speed : Double?) {
        if (speed != null) {
            this.speed = speed
        }
    }

    fun getDeg(): Int? {
        return deg
    }

    fun setDeg(deg : Int?) {
        if (deg != null) {
            this.deg = deg
        }
    }

}
