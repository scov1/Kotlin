package org.step.students.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var desc: String,
    var group: String,
    var birthday : String,
    var mark: Float,
    var avatar: Int
)