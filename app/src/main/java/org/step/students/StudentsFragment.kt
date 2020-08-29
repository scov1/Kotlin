package org.step.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StudentsFragment : Fragment() {

    val students:ArrayList<Student> = ArrayList()
    var recyclerView : RecyclerView? = null
    var adapter : StudentAdapter? = null
    private var rootView : View? = null


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
        initializeData()
        initializeRecyclerView()
        initializeLayoutManager()


    }


    private fun initializeData(){
        students.add(Student().apply { avatar=R.drawable.img1; name = "Tom Ford";desc= "Good person!" })
        students.add(Student().apply { avatar=R.drawable.img1; name = "Roberto Cavalli";desc= "Good man!" })
        students.add(Student().apply { avatar=R.drawable.img1; name = "Dior";desc= "Good girl!" })
    }


    private fun initializeLayoutManager(){
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = StudentAdapter(students)
    }

    private fun initializeView(){
        recyclerView = rootView?.findViewById(R.id.recyclerview_fragment_students)
    }

    private fun initializeRecyclerView(){
        recyclerView?.adapter = adapter
    }


}