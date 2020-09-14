package org.step.students.presentation.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import org.step.students.presentation.interfaces.ListenerStudent
import org.step.students.R
import org.step.students.data.Student

class StudentViewHolder(view:View, private var listener: ListenerStudent):RecyclerView.ViewHolder(view) {

        private val img: ImageView = itemView.findViewById(R.id.imageView_fragment_item_photo)
        private val userName: TextView = itemView.findViewById(R.id.textView_fragment_item_name)
        private val userDesc: TextView  = itemView.findViewById(R.id.textView_fragment_item_desc)
        private val userGroup: TextView = itemView.findViewById(R.id.textView_fragment_item_viewGroup)
        private val userMark : TextView = itemView.findViewById(R.id.textView_fragment_item_mark)


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
