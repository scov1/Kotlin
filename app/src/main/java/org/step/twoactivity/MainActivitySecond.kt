package org.step.twoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_second.*

class MainActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_second)

        var surname: String? = intent.getStringExtra("surname")

        textView_activity_main_second.text = "My surname :  $surname"

    }
}