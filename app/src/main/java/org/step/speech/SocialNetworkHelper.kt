package org.step.speech

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.social_network_helper.*

class SocialNetworkHelper : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speech_recognizer_helper)



        btn_send.setOnClickListener {

            sendMessageWhatsapp()

        }

        btn_getData.setOnClickListener{
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