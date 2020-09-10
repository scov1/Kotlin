package org.step.students.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.step.students.presentation.interfaces.ListenerStudent
import org.step.students.R
import org.step.students.presentation.viewholder.StudentViewHolder
import org.step.students.data.Student


class StudentAdapter(
    private val students: ArrayList<Student>,
    private var listener : ListenerStudent
    ): RecyclerView.Adapter<StudentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        return StudentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_item,parent,false),listener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        (holder as StudentViewHolder).bindView(students[position], position)

    }


    override fun getItemCount(): Int =students.size
}


