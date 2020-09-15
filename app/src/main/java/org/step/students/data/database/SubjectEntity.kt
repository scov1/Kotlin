package org.step.students.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SubjectEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name : String

)