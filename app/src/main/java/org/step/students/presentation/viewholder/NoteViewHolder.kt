package org.step.students.presentation.viewholder

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.red
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import org.step.students.R
import org.step.students.data.Note
import java.time.LocalDate
import java.util.*

class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val noteTitle: TextView = itemView.findViewById(R.id.textView_fragment_note_title)
    private val noteDesc: TextView = itemView.findViewById(R.id.textView_fragment_note_desc)
    private val noteDate: TextView = itemView.findViewById(R.id.textView_fragment_note_date)
    private val noteLayout : RelativeLayout = itemView.findViewById(R.id.relativeLayout_fragment_note_change)


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    fun bindView(note: Note, position: Int) {

        noteTitle.text = note.title
        noteDesc.text = note.desc
        noteDate.text = note.date.toString()
      //  itemView.setOnClickListener { listener.onItemClick(note) }

        if(noteDate.text as String == LocalDate.now().toString()){
            noteLayout?.setBackgroundColor(Color.parseColor("#e80e1c"))
        }

        Log.d("Adapter","NoteViewHolder")
    }

}