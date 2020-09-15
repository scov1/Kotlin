package org.step.students.data.database

import androidx.room.*


@Dao
interface SubjectDao {

    @Query("SELECT * FROM SubjectEntity WHERE id == :id")
    fun getSubjectById(id: Int): SubjectEntity

    @Query("SELECT * FROM SubjectEntity")
    fun getSubjects(): List<SubjectEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun initiateInsertSubject(entity: SubjectEntity)

    @Update
    fun initiateUpdateSubject(entity: SubjectEntity)

    @Delete
    fun initiateDeleteSubject(entity: SubjectEntity)
}