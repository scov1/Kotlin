package org.step.twoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button_activity_main_get.setOnClickListener{
            getData()
        }
    }


    private fun getData(){
        var intent  = Intent(this,MainActivitySecond::class.java)
        intent.putExtra("surname",textView_activity_main_one.text)

        startActivity(intent)
    }
}