package org.step.students.presentation.adapter

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import org.step.students.data.Student
import org.step.students.presentation.fragment.DetailStudentsFragment
import org.step.students.presentation.fragment.StudentPagerFragment
import org.step.students.presentation.fragment.StudentsFragment

class StudentPagerAdapter(fragmentManager: FragmentManager, var students: ArrayList<Student>): FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {

           return  StudentPagerFragment().newInstance(students[position])
    }

    override fun getCount(): Int {
        return students.size
    }
}