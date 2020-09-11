package org.step.students.presentation.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_notes.*
import kotlinx.android.synthetic.main.fragment_students.*
import org.step.students.R
import org.step.students.data.Note
import org.step.students.data.Student
import org.step.students.presentation.adapter.NoteAdapter
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList


class NoteFragment : Fragment() {

    var notes:ArrayList<Note> = ArrayList()
    var adapter : NoteAdapter? = null
    private var rootView : View? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = this.arguments
        if(bundle!=null){
            val note = bundle.getParcelable<Note>("NOTE")
            note.let {
                if (it != null) {
                    notes.add(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_notes, container, false)
        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeData()
        initializeAdapter()
        initializeRecyclerView()
        initializeLayoutManager()
        initializeListeners()

        adapter?.notifyDataSetChanged()

        Log.d("NoteAdapter", "Initialize")


    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initializeData(){

        notes.add(Note("Clean home","Today i need to clean my apartment" ,LocalDate.parse("2020-05-20")))
        notes.add(Note("Barbershop","I will need to go to the salon" ,LocalDate.parse("2020-09-11")))
        notes.add(Note("Buy car","i want a new car" ,LocalDate.parse("2020-03-12")))
    }


    private fun initializeLayoutManager(){
        recyclerview_fragment_notes?.layoutManager = LinearLayoutManager(context)

    }

    private fun initializeAdapter(){
        adapter = NoteAdapter(notes)
    }


    private fun initializeRecyclerView(){
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(view!!.context)
        recyclerview_fragment_notes.layoutManager = layoutManager


    }

    private fun initializeListeners(){
        recyclerview_fragment_notes.adapter = adapter
    }

    fun addNote(note: Note, notes:ArrayList<Note>) {
        notes.add(note)
        adapter!!.notifyDataSetChanged()
    }

}