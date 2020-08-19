package org.step.social

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var btnSend: Button
    lateinit var login : EditText
    lateinit var pass : EditText
    lateinit var btnGetData : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.btn_send)
        login = findViewById(R.id.login)
        pass = findViewById(R.id.pass)
        btnGetData = findViewById(R.id.btn_getData)


        btnSend.setOnClickListener {

            sendMessageWhatsapp()

        }

        btnGetData.setOnClickListener{
            sendDataMessage()
        }
    }

    private fun sendDataMessage(){

        val intent=Intent().setAction(Intent.ACTION_SEND);
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Login: "+login.text.toString()+" Pass: "+pass.text.toString())
        startActivity(intent)
    }

    private fun sendMessageWhatsapp() {

        val intent = Intent().setAction(Intent.ACTION_SEND)
        intent.type = "text/plain"

        intent.putExtra(Intent.EXTRA_TEXT,"Hello i have written Intent which sending you this message")

        if(intent.resolveActivity(packageManager)==null){

            Toast.makeText(this,"Please install whatsapp first", Toast.LENGTH_SHORT).show()

        }
        startActivity(intent)
    }
}
