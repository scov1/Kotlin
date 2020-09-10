package org.step.students

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_item.*

import kotlinx.android.synthetic.main.fragment_students.*


class StudentsFragment : Fragment(),ListenerStudent{


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

        students.add(Student("Tom Ford","Good Man!" ,"SEP-172", R.drawable.img1))
        students.add(Student("Roberto Cavalli","Miuuu" ,"SEB-181", R.drawable.img1))
        students.add(Student("Dior","Good girl", "SEP-182", R.drawable.img1))


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

//     fun addStudent(name1 : String,desc1 : String,group1 : String,img : Int) {
//        students.add(Student().apply { name = "$name1 desc = $desc1 group= $group1"; avatar = img})
//
//    }

     fun addStudent(student: Student,students:ArrayList<Student>) {
        students.add(student)
        adapter!!.notifyDataSetChanged()
    }
}


