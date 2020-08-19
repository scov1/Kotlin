package org.step.testlogs

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var txt : TextView
    lateinit var btnGet : Button
    lateinit var btnCancel : Button
    private val TAG = "TestLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.txt)
        btnGet = findViewById(R.id.btn_get)
        btnCancel = findViewById(R.id.btn_cancel)
        Log.d(TAG, "testttt");


        btnGet.setOnClickListener{
            Log.d(TAG, "btn GET");
            txt.setText("BUTTON GET")
        }

        btnCancel.setOnClickListener{
            Log.d(TAG,"btn Cancel")
            txt.setText("BUTTON CANCEL")
        }
    }
}