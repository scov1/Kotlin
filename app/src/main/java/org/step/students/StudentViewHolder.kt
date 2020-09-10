package org.step.students

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class StudentViewHolder(view:View,var listener: ListenerStudent):RecyclerView.ViewHolder(view) {

        private val img: ImageView = itemView.findViewById(R.id.imageView_fragment_item_photo)
        private val userName: TextView = itemView.findViewById(R.id.textView_fragment_item_name)
        private val userDesc: TextView  = itemView.findViewById(R.id.textView_fragment_item_desc)
        private val userGroup: TextView = itemView.findViewById(R.id.textView_fragment_item_viewGroup)


        fun bindView(student: Student,position: Int) {
            student.avatar?.let { img.setImageResource(it) }
            userName.text = student.name
            userDesc.text = student.desc
            userGroup.text = student.group
            itemView.setOnClickListener { listener.onItemClick(student) }

            Log.d("Adapter","Tom")
        }
}
