package org.step.forecast.data.model

class CityList {

    private var id : Int? = null
    private var name : String? = null
    private var country : String? = null
    private var coord : Coord? = null

    fun CityList(){}


    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        if (id != null) {
            this.id = id
        }
    }

    fun getName(): String?{
        return name
    }


    fun setName(name : String?){
        this.name = name
    }

    fun getCountry(): String?{
        return country
    }


    fun setCountry(country : String?){
        this.country = country
    }

    fun getCoord(): Coord? {
        return coord
    }


    fun setCoord(coord : Coord) {
        this.coord = coord
    }

}