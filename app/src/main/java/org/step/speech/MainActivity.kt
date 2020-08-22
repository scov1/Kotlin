package org.step.speech

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var showVoice: TextView
    lateinit var btnVoice : Button
    val REQUEST_CODE_SPEECH_INPUT = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        initializeListeners()
    }

    private fun initializeViews(){
        showVoice = findViewById(R.id.activity_show_voice)
        btnVoice = findViewById(R.id.activity_btn_voice)
    }

    private fun initializeListeners(){
        btnVoice.setOnClickListener{
            speak()
        }
    }

    private fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something")

        try{
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT)
        }catch (e:Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_CODE_SPEECH_INPUT->{
                if(resultCode== Activity.RESULT_OK && null != data){
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    showVoice.text = result!![0]
                }
            }
        }
    }
}