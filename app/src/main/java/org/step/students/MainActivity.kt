package org.step.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_students.*

class MainActivity : AppCompatActivity() {

    private val studentFragment = StudentsFragment()
    private val createStudentsFragment = StudentCreateFragment()
    private var currentFragment : Fragment? = null
    var isVisibility: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeFragment(StudentsFragment())


        btn_fragment_students_plus_student.setOnClickListener{
            initializeFragment(StudentCreateFragment())
        }
    }

    private fun initializeFragment(fragment: Fragment) {

        if (currentFragment == null) {
            currentFragment = StudentsFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout_activity_main_container, studentFragment)
                .commit()


            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout_activity_main_container, createStudentsFragment)
                .hide(createStudentsFragment)
                .commit()

        } else {
            if (isVisibility) {
                supportFragmentManager.beginTransaction()
                    .hide(createStudentsFragment)
                    .show(studentFragment)
                    .commit()
            } else {
                supportFragmentManager
                    .beginTransaction()
                    .hide(studentFragment)
                    .show(createStudentsFragment)
                    .addToBackStack(null)
                    .commit()
            }
            isVisibility = !isVisibility
        }
    }

        fun fragmentData(student: Student){

            studentFragment.addStudent(student,studentFragment.students)
            initializeFragment(StudentsFragment())

        }
}
