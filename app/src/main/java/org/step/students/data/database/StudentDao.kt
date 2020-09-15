package org.step.students.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import org.step.students.data.Student


@Dao
 interface StudentDao {
    @Query("SELECT * FROM StudentEntity WHERE id == :id")
    fun getStudentById(id: Int): StudentEntity

    @Query("SELECT * FROM StudentEntity")
    fun getStudents(): List<StudentEntity>

    @Query("SELECT * FROM StudentEntity ORDER BY id ASC")
    fun readAllData():LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun initiateInsertStudent(entity: StudentEntity)

    @Update
    fun initiateUpdateStudent(entity: StudentEntity)

    @Delete
    fun initiateDeleteStudent(entity: StudentEntity)
}