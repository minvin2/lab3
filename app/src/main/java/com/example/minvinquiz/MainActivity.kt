package com.example.minvinquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun StartQuizClick(v: View)
    {

        if(enterName_field.text.toString().isEmpty())
        {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
        }else {
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra(Constants.PLAYER, enterName_field.text.toString())

            startActivity(intent)
            finish()
        }

    }

    fun AboutClick(v: View)
    {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    fun HighScoreClick(v: View)
    {
        val intent = Intent(this, HighScoreHistoryActivity::class.java)
        startActivity(intent)
    }
}