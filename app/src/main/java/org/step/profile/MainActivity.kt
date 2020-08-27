package org.step.profile

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var imgProfile : ImageView
    lateinit var nameProfile : EditText
    lateinit var surnameProfile : EditText
    lateinit var btnGetData : Button
    val REQUEST_CODE = 1001



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializeListeners()

    }


    private fun initializeViews(){
        imgProfile=findViewById(R.id.imageView_activity_profile_img)
        nameProfile = findViewById(R.id.editView_activity_main_name)
        surnameProfile = findViewById(R.id.editView_activity_main_surname)
        btnGetData = findViewById(R.id.btn_activity_main_getData)

    }

    private fun initializeListeners(){
        btnGetData.setOnClickListener(){

         //   startCamera()
            startProfile()

        }
    }

    private fun startProfile() {
        if(nameProfile.text.trim().isNotEmpty() && surnameProfile.text.trim().isNotEmpty()){
            var intent = Intent(this,ProfileActivity::class.java)
            intent.putExtra("FIRST_NAME",nameProfile?.text.toString())
            intent.putExtra("LAST_NAME",surnameProfile?.text.toString())


            startActivityForResult(intent,REQUEST_CODE)
        }else{
            Toast.makeText(this,"FirstName or LastName Required!!!",Toast.LENGTH_LONG).show()
        }
    }


    private fun startCamera(){
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,123)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                var bmp = data?.extras?.get("data") as Bitmap
                imgProfile.setImageBitmap(bmp)

            }
        }
    }
}