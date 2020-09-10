package org.step.students.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.fragment_students.*
import org.step.students.presentation.interfaces.ListenerStudent
import org.step.students.R
import org.step.students.data.Student
import org.step.students.domain.StudentUtilsUseCase
import org.step.students.presentation.adapter.StudentAdapter


class StudentsFragment : Fragment(), ListenerStudent {


    var students:ArrayList<Student> = ArrayList()
    var adapter : StudentAdapter? = null
    private var rootView : View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = this.arguments
        if(bundle!=null){
            val student = bundle.getParcelable<Student>("STUDENT")
            student.let {
                if (it != null) {
                    students.add(it)
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_students,
            container,
            false
        )
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
        initializeListeners()

        adapter?.notifyDataSetChanged()

        Log.d("Adapter", "Initialize")

    }

    private fun initializeData(){

        students.add(Student("Tom Ford","Good Man!" ,"SEP-172",10f, R.drawable.img1))
        students.add(Student("Roberto Cavalli","Miuuu" ,"SEB-181",12f, R.drawable.img1))
        students.add(Student("Dior","Good girl", "SEP-182",8f, R.drawable.img1))

    }


    private fun initializeLayoutManager(){
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)

    }

    private fun initializeAdapter(){
        adapter = StudentAdapter(students,this)
    }


     private fun initializeRecyclerView(){
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(view!!.context)
        recyclerview_fragment_students.layoutManager = layoutManager
    }

    private fun initializeListeners(){
        recyclerview_fragment_students.adapter = adapter
    }

    override fun onItemClick(students: Student) {

        val fragment = DetailStudentsFragment()

        fragment.apply {
            arguments = Bundle().apply {
                putParcelable("STUDENT", students)
            }
        }
        fragmentManager?.beginTransaction()
            ?.replace(R.id.frameLayout_activity_main_container, fragment)
            ?.hide(StudentsFragment())
            ?.addToBackStack(null)
            ?.commit()


    }

    fun sortByName(){
        StudentUtilsUseCase().sortByName(students)
        initializeAdapter()
    }

    fun sortByMark(){
        StudentUtilsUseCase().sortByMark(students)
        initializeAdapter()
    }

    fun sortByRandom(){
        StudentUtilsUseCase().sortByRandom(students)
        initializeAdapter()
    }

     fun addStudent(student: Student, students:ArrayList<Student>) {
        students.add(student)
        adapter!!.notifyDataSetChanged()
    }

    fun searchName(searchText: String) {
        if(searchText == "" && students.size >-1) {
            students.clear()
            students.addAll(students)
           // sortArrayByMarks()
        }
        else {
            val newStudents = StudentUtilsUseCase().search(students, searchText)
            students.clear()
            students.addAll(newStudents)
        }
        adapter!!.notifyDataSetChanged()
    }
}


