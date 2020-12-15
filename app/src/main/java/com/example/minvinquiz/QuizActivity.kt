package com.example.minvinquiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*


class QuizActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int=1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int =0
    private var mCorrectAnswers: Int =0
    private var mUserName:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        mUserName= intent.getStringExtra(Constants.PLAYER)
        mQuestionsList=Constants.getQuestions()
        setQuestion()
        radioButton.setOnClickListener(this)
        radioButton2.setOnClickListener(this)
        radioButton3.setOnClickListener(this)
        radioButton4.setOnClickListener(this)
        button_submit.setOnClickListener(this)


    }

    private fun setQuestion()
    {

        val question= mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size)
        {
            button_submit.text="FINISH"
        }else {
            button_submit.text="SUBMIT"
        }

        progressBar.progress=mCurrentPosition
        tv_progress.text="$mCurrentPosition" +"/"+ progressBar.max

        questionText.text=question.question
        radioButton.text=question.optionOne
        radioButton2.text=question.optionTwo
        radioButton3.text=question.optionThree
        radioButton4.text=question.optionFour


    }

    private fun defaultOptionsView() {



        val options= ArrayList<RadioButton>()
        options.add(0, radioButton)
        options.add(1, radioButton2)
        options.add(2, radioButton3)
        options.add(3, radioButton4)

        for(option in options)
        {
            option.setTextColor(Color.rgb(0, 0, 0))

        }
    }


    private fun selectedOptionView(tv: RadioButton, selectedoptionNum: Int)
    {
        defaultOptionsView()
        mSelectedOptionPosition= selectedoptionNum
        tv.setTextColor(Color.rgb(255, 255, 255))

    }

    fun unchecked() {
        val x = findViewById<RadioGroup>(R.id.radio_group)
        x.clearCheck()
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.radioButton -> {

                selectedOptionView(radioButton, 1)

            }
            R.id.radioButton2 -> {
                selectedOptionView(radioButton2, 2)


            }
            R.id.radioButton3 -> {
                selectedOptionView(radioButton3, 3)


            }
            R.id.radioButton4 -> {
                selectedOptionView(radioButton4, 4)

            }
            R.id.button_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.PLAYER, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {

                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        atsakymoView(mSelectedOptionPosition, 255, 0, 0)
                    } else {
                        mCorrectAnswers++
                    }

                    atsakymoView(question.correctAnswer, 0, 255, 0)
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        button_submit.text = "FINISH"
                    } else {
                        button_submit.text = "GO TO NEXT QUESTION"
                        unchecked()
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun atsakymoView(answer: Int, red: Int, green: Int, blue: Int){
        when(answer)
        {
            1 -> {
                radioButton.setTextColor(Color.rgb(red, green, blue))
            }
            2 -> {
                radioButton2.setTextColor(Color.rgb(red, green, blue))
            }
            3 -> {
                radioButton3.setTextColor(Color.rgb(red, green, blue))
            }
            4 -> {
                radioButton4.setTextColor(Color.rgb(red, green, blue))
            }
        }
    }


}