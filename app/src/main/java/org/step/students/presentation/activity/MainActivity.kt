package org.step.students.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.step.students.R
import org.step.students.data.Student
import org.step.students.presentation.fragment.StudentCreateFragment
import org.step.students.presentation.fragment.StudentsFragment

class MainActivity : BaseActivity() {
//
//    private val studentFragment = StudentsFragment()
//    private val createStudentsFragment = StudentCreateFragment()
//    private var currentFragment : Fragment? = null
//    var students:ArrayList<Student> = ArrayList()
//    var isVisibility: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeDefaultFragment()


        btn_fragment_students_plus_student.setOnClickListener{
            displayFragment(StudentCreateFragment())
            btn_fragment_students_sort_mark.visibility = View.GONE
            btn_fragment_students_sort_name.visibility = View.GONE
            btn_fragment_students_sort_random.visibility = View.GONE
            editText_fragment_students_search.visibility = View.GONE
        }

        btn_fragment_students_sort_name.setOnClickListener {
            studentFragment.sortByName()
        }

        btn_fragment_students_sort_mark.setOnClickListener {
            studentFragment.sortByMark()
        }

        btn_fragment_students_sort_random.setOnClickListener {
            studentFragment.sortByRandom()
        }

        btn_fragment_students_best_students.setOnClickListener {
            studentFragment.getTop()
        }


        editText_fragment_students_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.isNullOrEmpty())
                    studentFragment.searchName("")
                else
                    studentFragment.searchName(editText_fragment_students_search.text.toString())
            }
        })
    }
}
