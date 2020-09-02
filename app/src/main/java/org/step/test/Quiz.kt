package org.step.test

class Quiz(var question : String,var answ1:String,var answ2:String,var answ3:String,var answ4:String,var rightAnswer: Int) {

    fun isRightAnswer(answerCount:Int) : Boolean{
        if(answerCount == rightAnswer){
            return true
        }else{
            return false
        }
    }


}