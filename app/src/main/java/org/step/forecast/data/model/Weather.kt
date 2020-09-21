package org.step.forecast.data.model

class Weather {

    private var id = 0
    private var main: String? = ""
    private var description: String? = ""
    private var icon: String? = ""

    fun Weather(){}


    fun getId(): Int? {
        return id
    }

    fun setId(id : Int?) {
        if (id != null) {
            this.id = id
        }
    }


    fun getMain(): String? {
        return main
    }


    fun setMain(main : String?) {
        this.main = main
    }

    fun getDesc(): String? {
        return description
    }

    fun setDesc(description : String?) {
        this.description = description
    }


    fun getIcon(): String? {
        return icon
    }

    fun setIcon(icon : String?) {
        this.icon = icon
    }
}