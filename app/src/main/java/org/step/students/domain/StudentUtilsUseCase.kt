package org.step.students.domain

import org.step.students.Student

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

 //   fun searchByName(students: ArrayList<Student>, query : String):ArrayList<Student> {
//        if(query.isNotEmpty()){
//            students.forEach { student->
//                student.show = student.name.toUpperCase().indexOf(query.toUpperCase())>-1
//            }
//        }else{
//            students.forEach { student->student.show=true }
//        }
//        return students
 //   }
        fun search(students: ArrayList<Student>, search: String): ArrayList<Student> {
            search.trim(' ')
            val filtered = students.filter { it.name!!.toLowerCase().contains(search.toLowerCase()) }
            return ArrayList(filtered)
        }
}