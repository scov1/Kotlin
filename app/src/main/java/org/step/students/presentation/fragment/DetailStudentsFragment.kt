package org.step.students.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.step.students.R
import org.step.students.data.Student


class DetailStudentsFragment : Fragment() {


    private var img : ImageView? = null
    private var nameDetail : TextView? = null
    private var descDetail : TextView? = null
    private var groupDetail : TextView? = null
    private var markDetail : TextView? = null
    private var rootView : View? = null
    var student: Student? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            student = it.getParcelable("STUDENT")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         rootView = inflater.inflate(R.layout.fragment_detail_students, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeView()
    }


    private fun initializeView(){

        img = rootView?.findViewById(R.id.imageView_fragment_detail_students_avatar)
        nameDetail = rootView?.findViewById(R.id.textView_fragment_detail_students_name)
        descDetail = rootView?.findViewById(R.id.textView_fragment_detail_students_desc)
        groupDetail = rootView?.findViewById(R.id.textView_fragment_detail_viewGroup)
        markDetail = rootView?.findViewById(R.id.textView_fragment_detail_mark)


        student?.avatar?.let { img?.setImageResource(it) }
        nameDetail?.text= student?.name
        descDetail?.text = student?.desc
        groupDetail?.text = student?.group
        markDetail?.text = student?.mark.toString()


    }
}