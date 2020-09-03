package org.step.students

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail_students.*
import kotlinx.android.synthetic.main.fragment_students.*


class StudentsFragment : Fragment() {


    var students:ArrayList<Student> = ArrayList()
    var recyclerView : RecyclerView? = null
    var adapter : StudentAdapter? = null
    private var rootView : View? = null
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val bundle = this.arguments
//        if(bundle!=null){
//            val stud = bundle.getParcelable<Student>("STUDENT")
//            stud.let {
//                if (it != null) {
//                    students.add(it)
//                }
//            }
//        }
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_students, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeView()
        initializeLayoutManager()
        initializeData()
    //    initializeRecyclerView()
        adapter?.notifyDataSetChanged()
        Log.d("Adapter","Initialize")

    }


    private fun initializeData(){
//        students= ArrayList<Student>().apply { add(Student( "Tom Ford","Good person!",R.drawable.img1, ))
//            add(Student( "Roberto Cavalli","Good man!",R.drawable.img1, ))
//            add(Student( "Dior","Good girl!",R.drawable.img1, ))
//        }

        students.add(Student("Tom Ford","Good person!","SEP-172",R.drawable.img1))
        students.add(Student( "Roberto Cavalli","Good man!","SEB-181",R.drawable.img1))
        students.add(Student( "Dior","Good girl!","SEP-182" ,R.drawable.img1))
    }


    private fun initializeLayoutManager(){
        recyclerView?.layoutManager = LinearLayoutManager(context)


        recyclerView?.adapter = StudentAdapter(context!! ,students){
            val intent = Intent(view!!.context,DetailStudents::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)

        }
    }


    private fun initializeView(){
        recyclerView = rootView?.findViewById(R.id.recyclerview_fragment_students)
    }

}