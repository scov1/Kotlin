package org.step.students.data.database

import androidx.lifecycle.LiveData
import org.step.students.data.Student

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData : LiveData<List<Student>> = studentDao.readAllData()


}