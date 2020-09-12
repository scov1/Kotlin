package org.step.students.presentation.adapter

import android.content.Context
import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import org.step.students.data.Student
import org.step.students.presentation.fragment.DetailStudentsFragment
import org.step.students.presentation.fragment.NoteFragment
import org.step.students.presentation.fragment.StudentPagerFragment
import org.step.students.presentation.fragment.StudentsFragment

class StudentPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList : MutableList<Fragment> = ArrayList()
    private val nameFragment : MutableList<String> = ArrayList()



    override fun getItem(position: Int): Fragment {

        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragment(fragment: Fragment,name : String){
        fragmentList.add(fragment)
        nameFragment.add(name)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return nameFragment[position]
    }


}