package org.step.students.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.step.students.R
import org.step.students.data.Student
import org.step.students.presentation.fragment.StudentCreateFragment
import org.step.students.presentation.fragment.StudentsFragment

open class BaseActivity : AppCompatActivity() {

    val studentFragment = StudentsFragment()
    val createStudentsFragment = StudentCreateFragment()
    var currentFragment : Fragment? = null
    var isVisibility: Boolean = false
    var students:ArrayList<Student> = ArrayList()



    fun displayFragment(fragmentTemp: Fragment) {
        if(currentFragment != null) {
            if(isVisibility) {
                supportFragmentManager
                    .beginTransaction()
                    .hide(createStudentsFragment)
                    .show(studentFragment)
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .hide(studentFragment)
                    .show(createStudentsFragment)
                    .commit()
            }

            isVisibility = !isVisibility
        }
    }

    fun initializeDefaultFragment() {
        currentFragment = StudentsFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, studentFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container, createStudentsFragment)
            .hide(createStudentsFragment)
            .commit()
    }


    fun fragmentData(student: Student){

        studentFragment.addStudent(student,studentFragment.students)
        displayFragment(StudentsFragment())

    }
}