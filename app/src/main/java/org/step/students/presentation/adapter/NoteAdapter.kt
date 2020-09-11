package org.step.students.presentation.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import org.step.students.R
import org.step.students.data.Note
import org.step.students.presentation.viewholder.NoteViewHolder


class NoteAdapter(
    private val notes: ArrayList<Note>

): RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_note,parent,false))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            (holder as NoteViewHolder).bindView(notes[position], position)
    }

    override fun getItemCount(): Int =notes.size

}