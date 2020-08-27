package org.step.profile

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity: AppCompatActivity() {

    var RESULT_CODE= 1002
    lateinit var imgProfile : ImageView
    lateinit var firstName : TextView
    lateinit var lastName : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initializeViews()
        startProfile()


    }

    private fun initializeViews(){
        imgProfile=findViewById(R.id.imageView_activity_profile_img)
        firstName = findViewById(R.id.textView_activity_profile_name)
        lastName = findViewById(R.id.textView_activity_profile_surname)

    }


    private fun startProfile() {
        val intent = getIntent()
         firstName.text = intent.getStringExtra("FIRST_NAME")
         lastName.text = intent.getStringExtra("LAST_NAME")




    }
}