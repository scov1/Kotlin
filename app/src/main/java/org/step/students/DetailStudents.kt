package org.step.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailStudents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_students)

        val stud = intent.getParcelableExtra<Student>(StudentsFragment.INTENT_PARCELABLE)
        var img = findViewById<ImageView>(R.id.imageView_activity_detail_students_avatar)
        var nameDetail = findViewById<TextView>(R.id.textView_activity_detail_students_name)
        var descDetail = findViewById<TextView>(R.id.textView_activity_detail_students_desc)

        stud?.avatar?.let { img.setImageResource(it) }
        nameDetail.text= stud?.name
        descDetail.text = stud?.desc
    }
}