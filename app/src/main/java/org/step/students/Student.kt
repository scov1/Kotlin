package org.step.students

import android.os.Parcel
import android.os.Parcelable


data class Student(

    var name: String?,
    var desc: String?,
    var group: String?,
    var avatar: Int? = null
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(group)
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
//     constructor(parcel: Parcel) : this(
//         parcel.readString(),
//         parcel.readString(),
//         parcel.readString(),
//         parcel.readValue(Int::class.java.classLoader) as? Int
//     ) {
//     }
//
//     override fun writeToParcel(parcel: Parcel, flags: Int) {
//         parcel.writeString(name)
//         parcel.writeString(desc)
//         parcel.writeString(group)
//         parcel.writeValue(avatar)
//     }
//
//     override fun describeContents(): Int {
//         return 0
//     }
//
//     companion object CREATOR : Parcelable.Creator<Student> {
//         override fun createFromParcel(parcel: Parcel): Student {
//             return Student(parcel)
//         }
//
//         override fun newArray(size: Int): Array<Student?> {
//             return arrayOfNulls(size)
//         }
//     }

// }