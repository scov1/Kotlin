package org.step.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initializeDefaultFragment()
    }

    private fun initializeDefaultFragment(){
        val fragment = StudentsFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout_activity_main_container,fragment)
            .commit()
    }
}