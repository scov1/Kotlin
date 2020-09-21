package org.step.forecast.data.model

class Clouds {

    var all = 0


    fun Clouds(){}


    fun getAll(): Int? {
        return all
    }

    fun setLon(all : Int?) {
        if (all != null) {
            this.all = all
        }
    }


}
