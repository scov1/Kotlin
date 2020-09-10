package org.step.students

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView


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


