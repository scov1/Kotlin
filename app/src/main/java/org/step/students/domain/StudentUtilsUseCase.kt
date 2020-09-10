package org.step.students.domain

import org.step.students.data.Student

class StudentUtilsUseCase {

    fun sortByName(students:ArrayList<Student>) {
        return students.sortBy{student->student.name}
    }

    fun sortByMark(students:ArrayList<Student>) {
        return students.sortBy{student->student.mark}
    }

    fun sortByRandom(students:ArrayList<Student>) {
        return students.shuffle()
    }

    fun search(students: ArrayList<Student>, search: String): ArrayList<Student> {
            search.trim(' ')
            val filtered = students.filter { it.name!!.toLowerCase().contains(search.toLowerCase()) }
            return ArrayList(filtered)
    }

    fun getTopStudents(students: ArrayList<Student>): ArrayList<Student> {

        val topStudentsByMark: ArrayList<Student> = ArrayList()
        var topStudent: Student

        for (i: Int in 0 until 3) {
            topStudent = students.first()
            for (student in students) {
                if(student.mark!! < topStudent.mark!!) {
                    topStudent = student
                }
            }
            topStudentsByMark.add(topStudent)
            students.remove(topStudent)
        }

        return topStudentsByMark
    }
}