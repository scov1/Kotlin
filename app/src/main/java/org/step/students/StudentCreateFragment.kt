package org.step.students

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_student_create.*


class StudentCreateFragment : Fragment() {
//    val fragment = StudentsFragment()

    private var rootView : View? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         rootView = inflater.inflate(R.layout.fragment_student_create, container, false)
        return rootView
    }



    @RequiresApi(Build.VERSION_CODES.M)
    fun initialRequestCamera(){
        activity?.requestPermissions( arrayOf(android.Manifest.permission.CAMERA),123)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
        initializeViews()


        button_fragment_student_create_add_student.setOnClickListener{
            initializeData()
//            addStudent()
        }

    }
//
//    fun initializeData(){
//
//        name = textView_fragment_student_create_name.text.toString()
//        desc = textView_fragment_student_create_desc.text.toString()
//        group = textView_fragment_student_create_group.text.toString()
//        img = imageView_fragment_student_create_img.imageAlpha
//    }

     private fun initializeViews(){

//         val fragmentManager = fragmentManager
//         fragmentManager?.popBackStack()

         imageView_fragment_student_create_img?.setImageDrawable(ContextCompat.getDrawable(view?.context!!,R.drawable.img1))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initializeListeners() {

        button_fragment_student_create_photo.setOnClickListener {
            if (activity?.checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                initialRequestCamera()
            else
                startCamera()
        }
    }

    private fun initializeData() {

        val activity : Activity? = activity

            when {
                textView_fragment_student_create_name.text.toString().isEmpty() -> {
                    Toast.makeText(activity, "Name can't be empty!", Toast.LENGTH_LONG).show()
                }
                textView_fragment_student_create_desc.text.toString().isEmpty() -> {
                    Toast.makeText(activity, "Description can't be empty", Toast.LENGTH_LONG).show()
                }
                textView_fragment_student_create_group.text.toString().isEmpty() -> {
                    Toast.makeText(activity, "Group can't be empty", Toast.LENGTH_LONG).show()
                }
                else -> {
                    val arguments = Bundle()

                    var student: Student = Student(
                        textView_fragment_student_create_name.text.toString(),
                        textView_fragment_student_create_desc.text.toString(),
                        textView_fragment_student_create_group.text.toString(),
                        //imageView_fragment_student_create_img.setImageDrawable(R.drawable.img1)

                    )


                    arguments.putParcelable("STUDENT", student)
                    Log.d("Adapter","student")
                    if(activity !=null && !activity.isFinishing && activity is MainActivity)
                    activity.fragmentData(student)
                   Log.d("Adapter","stud2")
                }
            }
        }


    fun startCamera() {

        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,123)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if(requestCode==123){
                    var bmp = data?.extras?.get("data") as Bitmap
                    imageView_fragment_student_create_img.setImageBitmap(bmp)
            }
    }
}