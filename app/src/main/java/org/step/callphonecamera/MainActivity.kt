package org.step.callphonecamera

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var img : ImageView
    lateinit var btnImg : Button
    lateinit var btnCall : Button
    val phoneNumber = "77029552207"
    val REQUEST_PHONE_CALL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.action_img)
        btnImg = findViewById(R.id.action_btn_img)
        btnCall = findViewById(R.id.action_btn_phone)

       // requestPermissions{android.Manifest.permission.CAMERA}

        btnImg.setOnClickListener{
            if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),123)
            }else{
                startCamera()
            }
        }

        btnCall.setOnClickListener{

            if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)
            }else{
                startCall()
            }
        }
    }

    private fun startCamera() {

        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,123)
    }

    private fun startCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel: $phoneNumber")
        startActivity(intent)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==123){
            var bmp = data?.extras?.get("data") as Bitmap
            img.setImageBitmap(bmp)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode === REQUEST_PHONE_CALL)startCall()
    }
}