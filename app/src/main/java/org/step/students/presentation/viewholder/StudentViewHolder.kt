package org.step.students.presentation.viewholder

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import androidx.recyclerview.widget.RecyclerView
import org.step.students.presentation.interfaces.ListenerStudent
import org.step.students.R
import org.step.students.data.Student
import org.step.students.data.database.EducationDatabase
import org.step.students.data.database.StudentRepository

class StudentViewHolder(view:View, private var listener: ListenerStudent) :RecyclerView.ViewHolder(view) {


         val img: ImageView = itemView.findViewById(R.id.imageView_fragment_item_photo)
         val userName: TextView = itemView.findViewById(R.id.textView_fragment_item_name)
         val userDesc: TextView = itemView.findViewById(R.id.textView_fragment_item_desc)
         val userGroup: TextView = itemView.findViewById(R.id.textView_fragment_item_viewGroup)
         val userMark: TextView = itemView.findViewById(R.id.textView_fragment_item_mark)


  //      private val readAllData : LiveData<List<Student>>
  //      private val repository : StudentRepository


 //       init{
//            val studentDao = EducationDatabase.getStudentDao().initiateInsertStudent(org.step.students.data.Student())
//            repository = StudentRepository(studentDao)
//            readAllData = repository.readAllData

     //   }



        fun bindView(student: Student, position: Int) {
            student.avatar?.let { img.setImageResource(it) }
            userName.text = student.name
            userDesc.text = student.desc
            userGroup.text = student.group
            userMark.text = student.mark.toString()

            itemView.setOnClickListener { listener.onItemClick(student) }

            Log.d("Adapter","Tom")
        }
}
