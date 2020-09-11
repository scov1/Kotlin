package org.step.students.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate


@Parcelize
class Note (
    var title : String? = null,
    var desc : String? = null,
    var date : LocalDate? = null
) : Parcelable
