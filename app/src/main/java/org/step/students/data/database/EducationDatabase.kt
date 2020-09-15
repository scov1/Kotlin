package org.step.students.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(StudentEntity::class,SubjectEntity::class), version = 2)
abstract class EducationDatabase : RoomDatabase(){

    abstract fun StudentDao(): StudentDao
    abstract fun SubjectDao(): SubjectDao


    companion object{
        @Volatile
        private var INSTANCE : EducationDatabase? = null


        fun getDatabase(context: Context) : EducationDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EducationDatabase::class.java,
                    "education_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}