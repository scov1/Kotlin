package org.step.apiversion

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val sdk = Build.VERSION.SDK_INT
    val release = Build.VERSION.RELEASE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView_activity_main_api.text = "SDK Version : $sdk ($release)"
    }
}