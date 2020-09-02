package org.step.test

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {


    var countRightAnswer : Int = 0
    var quizIndex :Int = 0
    var quizArray = ArrayList<Quiz>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizArray.add(Quiz("Name the capital of Kazakhstan?", "Karaganda", "Almaty", "Nur-Sultan","Shymkent",3))
        quizArray.add(Quiz("Name the capital of USA?", "New-York", "Las-Vegas", "Miami","Washington",4))
        quizArray.add(Quiz("Name the capital of Australia?", "Melbourne", "Sydney", "Canberra","Brisbane",3))
        quizArray.add(Quiz("Name the capital of Сanada?", "Toronto","Ottawa","Montréal","Calgary",2))

        showQuestion(quizArray.get(quizIndex))



        button_activity_main_answer_one.setOnClickListener{
            handleAnswer(1)
        }

        button_activity_main_answer_two.setOnClickListener{
            handleAnswer(2)
        }

        button_activity_main_answer_three.setOnClickListener{
            handleAnswer(3)
        }

        button_activity_main_answer_four.setOnClickListener{
            handleAnswer(4)
        }
    }

    private fun showQuestion(quiz: Quiz){

        textView_activity_main_question.text =quiz.question
        button_activity_main_answer_one.setText(quiz.answ1)
        button_activity_main_answer_two.setText(quiz.answ2)
        button_activity_main_answer_three.setText(quiz.answ3)
        button_activity_main_answer_four.setText(quiz.answ4)

    }

    fun handleAnswer(answerId : Int){
        val quiz = quizArray.get(quizIndex)
        if(quiz.isRightAnswer(answerId)){
            countRightAnswer++
            Toast.makeText( this,"Right!" ,Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this, "Oh,Sorry,it's not right!", Toast.LENGTH_SHORT).show()
        }

        quizIndex++

        if(quizIndex >= quizArray.size){

            textView_activity_main_answer.visibility = View.VISIBLE
            textView_activity_main_answer.setText("Вы ответила правильно на : " + countRightAnswer + " ответ(а)")


        }else{
            showQuestion(quizArray[quizIndex])
        }
    }


}


