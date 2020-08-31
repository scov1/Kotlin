package org.step.students

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student (

    var name : String,
    var desc : String,
    var avatar : Int? = null
    ) : Parcelable