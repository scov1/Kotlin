package org.step.speech

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.speech_recognizer_helper.*
import java.lang.Exception
import java.util.*

class SpeechRecognizerHelper :AppCompatActivity(){


    private val REQUEST_CODE_SPEECH_INPUT = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speech_recognizer_helper)


        initializeListeners()
    }


    private fun initializeListeners(){
        activity_btn_voice.setOnClickListener{
            speak()
        }
    }

    private fun speak() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something")

        try{
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT)
        }catch (e: Exception){
            Toast.makeText(this,e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            REQUEST_CODE_SPEECH_INPUT->{
                if(resultCode== Activity.RESULT_OK && null != data){
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    activity_show_voice.text = result!![0]
                }
            }
        }
    }
}