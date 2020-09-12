package org.step.students.presentation.fragment

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_note_create.*
import kotlinx.android.synthetic.main.fragment_student_create.*
import org.step.students.R
import org.step.students.data.Note
import org.step.students.data.Student
import org.step.students.presentation.activity.MainActivity
import java.time.LocalDate
import java.util.*


class NoteCreateFragment : Fragment() {

    private var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_note_create, container, false)
        return rootView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button_fragment_note_create_add_note.setOnClickListener {
            initializeData()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initializeData() {

        val activity: Activity? = activity

        when {
            textView_fragment_note_create_title.text.toString().isEmpty() -> {
                Toast.makeText(activity, "Title can't be empty!", Toast.LENGTH_LONG).show()
            }
            textView_fragment_note_create_desc.text.toString().isEmpty() -> {
                Toast.makeText(activity, "Description can't be empty", Toast.LENGTH_LONG).show()
            }
            textView_fragment_note_create_date.text.toString().isEmpty() -> {
                Toast.makeText(activity, "Date can't be empty", Toast.LENGTH_LONG).show()
            }

            else -> {
                val arguments = Bundle()

                var note: Note = Note(
                    textView_fragment_note_create_title.text.toString(),
                    textView_fragment_note_create_desc.text.toString(),
                    LocalDate.now()
                )
//
//
//                arguments.putParcelable("STUDENT", note)
//                Log.d("Adapter", "note")
//                if (activity != null && !activity.isFinishing && activity is MainActivity)
//                   activity.fragmentData(note)
                    Log.d("Adapter", "note2 get")
            }
        }
    }
}
