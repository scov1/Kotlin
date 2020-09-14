package org.step.students.data

import android.os.Parcel
import android.os.Parcelable


data class Student(

    var name: String?,
    var desc: String?,
    var group: String?,
    var birthday : String?,
    var mark: Float? = null,

    var avatar: Int? = null
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
   //     parcel.readValue(Int::class.java.classLoader) as? Int
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(group)
        parcel.writeString(birthday)
        parcel.writeValue(avatar)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}