package org.step.students.presentation.activity

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_student_create.*
import kotlinx.android.synthetic.main.fragment_students.*
import org.step.students.R
import org.step.students.data.Student
import org.step.students.data.database.*
import org.step.students.presentation.adapter.StudentPagerAdapter
import org.step.students.presentation.fragment.NoteCreateFragment
import org.step.students.presentation.fragment.NoteFragment
import org.step.students.presentation.fragment.StudentCreateFragment
import org.step.students.presentation.fragment.StudentsFragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : BaseActivity(), DatePickerDialog.OnDateSetListener {
//
//    private val studentFragment = StudentsFragment()
//    private val createStudentsFragment = StudentCreateFragment()
//    private var currentFragment : Fragment? = null
//    var students:ArrayList<Student> = ArrayList()
//    var isVisibility: Boolean = false
      private var tabLayout: TabLayout? = null
      private var viewPager: ViewPager? = null
      private var db : EducationDatabase? = null
      private var studentDao : StudentDao? = null
      private var subjectDao : SubjectDao? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


   //    initializeDefaultFragment()


        val button = findViewById<Button>(R.id.btn_activity_main_click_student)
        button.setOnClickListener (View.OnClickListener {
            Observable.fromCallable(
                {
                    db = EducationDatabase.getDatabase(this)
                    studentDao = db?.StudentDao()
                    var student = StudentEntity(12,"Jack","Fantastic man","SEP-180","19-02-1992",12f,R.drawable.img1)
                    with(studentDao){
                        this?.initiateInsertStudent(student)

                    }
                    db?.StudentDao()?.getStudents()
                }
            ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    Log.d("adapter",it?.size.toString())

                },
                {
                    Log.d("error","error")
                }
            )
        })


        val button2 = findViewById<Button>(R.id.btn_activity_main_click_subject)
        button2.setOnClickListener (View.OnClickListener {
            Observable.fromCallable(
                {
                    db = EducationDatabase.getDatabase(this)
                    subjectDao = db?.SubjectDao()
                    var subject = SubjectEntity(11,"SEP-182")
                    with(subjectDao){
                        this?.initiateInsertSubject(subject)

                    }
                    db?.SubjectDao()?.getSubjects()
                }
            ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                {
                    Log.d("size",it?.size.toString())

                },
                {
                    Log.d("error","error")
                }
            )
        })







        btn_fragment_students_best_students.visibility = View.GONE
        editText_fragment_students_search.visibility = View.GONE
        btn_fragment_students_sort_mark.visibility = View.GONE
        btn_fragment_students_sort_name.visibility = View.GONE
        btn_fragment_students_sort_random.visibility = View.GONE


        btn_fragment_students_plus_student.setOnClickListener {
            displayFragment(StudentCreateFragment())
        }
//

//
//        btn_fragment_add_plus_note.setOnClickListener{
//            displayFragment(NoteCreateFragment())
//            btn_fragment_students_sort_mark.visibility = View.GONE
//            btn_fragment_students_sort_name.visibility = View.GONE
//            btn_fragment_students_sort_random.visibility = View.GONE
//            editText_fragment_students_search.visibility = View.GONE
//        }

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

        adapter.addFragment(StudentCreateFragment(),"CREATE STUDENT")
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault())
        val date = LocalDate.of(year, monthOfYear, dayOfMonth)
        textView_fragment_student_create_birthday?.setText(date.format(formatter))
    }
}
