package org.step.students.presentation.activity

import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.step.students.R
import org.step.students.data.Student
import org.step.students.presentation.adapter.StudentPagerAdapter
import org.step.students.presentation.fragment.NoteCreateFragment
import org.step.students.presentation.fragment.NoteFragment
import org.step.students.presentation.fragment.StudentCreateFragment
import org.step.students.presentation.fragment.StudentsFragment

class MainActivity : BaseActivity() {
//
//    private val studentFragment = StudentsFragment()
//    private val createStudentsFragment = StudentCreateFragment()
//    private var currentFragment : Fragment? = null
//    var students:ArrayList<Student> = ArrayList()
//    var isVisibility: Boolean = false
      private var tabLayout: TabLayout? = null
      private var viewPager: ViewPager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


   //    initializeDefaultFragment()


        btn_fragment_students_plus_student.visibility = View.GONE
        btn_fragment_students_best_students.visibility = View.GONE
        editText_fragment_students_search.visibility = View.GONE
        btn_fragment_students_sort_mark.visibility = View.GONE
        btn_fragment_students_sort_name.visibility = View.GONE
        btn_fragment_students_sort_random.visibility = View.GONE

        btn_fragment_students_plus_student.setOnClickListener{
            displayFragment(StudentCreateFragment())
            btn_fragment_students_sort_mark.visibility = View.GONE
            btn_fragment_students_sort_name.visibility = View.GONE
            btn_fragment_students_sort_random.visibility = View.GONE
            editText_fragment_students_search.visibility = View.GONE
        }

        btn_fragment_add_plus_note.setOnClickListener{
            displayFragment(NoteCreateFragment())
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


        tabLayout = findViewById(R.id.tabLayout_activity_main_tabs)
        viewPager = findViewById(R.id.viewPager_activity_main_pager)

        val adapter = StudentPagerAdapter(supportFragmentManager)
        adapter.addFragment(StudentsFragment(),"Students")
        adapter.addFragment(NoteFragment(),"NOTES")

        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)

    }
}
