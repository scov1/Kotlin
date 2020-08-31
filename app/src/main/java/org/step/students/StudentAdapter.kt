package org.step.students

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val context : Context,
    private val students: ArrayList<Student>,
    val listener : (Student) -> Unit
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val img = itemView.findViewById<ImageView>(R.id.imageView_fragment_item_photo)
        val userName = itemView.findViewById<TextView>(R.id.textView_fragment_item_name)
        val userDesc = itemView.findViewById<TextView>(R.id.textView_fragment_item_desc)

        fun bindView(student: Student,listener: (Student) -> Unit) {
            student.avatar?.let { img.setImageResource(it) }
            userName.text = student.name
            userDesc.text = student.desc
            itemView.setOnClickListener{listener(student)}
            Log.d("Adapter","Tom")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_item,parent,false))



    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindView(students[position],listener)


    }


    override fun getItemCount(): Int =students.size
}


