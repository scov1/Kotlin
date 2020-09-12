package org.step.students.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_student_pager.*
import org.step.students.R
import org.step.students.data.Student

class StudentPagerFragment : Fragment() {

    var rootView: View? = null
    val students: ArrayList<Student> = ArrayList()

    fun newInstance(student : Student): DetailStudentsFragment {
        val args = Bundle()
        
        val fragment = DetailStudentsFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_student_pager, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DetailStudentsFragment()
    }
}

