package com.example.minvinquiz

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*


class ResultActivity : AppCompatActivity() {

    var data = mutableListOf<Player>()
    lateinit var database: AppDatabase
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        database = AppDatabase.getInstance(this)!!
        val username = intent.getStringExtra(Constants.PLAYER)
        player_field.text=username
        val totalQuestion= intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers =intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        score.text="Your Score is $correctAnswers out of $totalQuestion"

        button_done.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        button3.setOnClickListener{
            val player = Player(0, username, correctAnswers)

            database
                .getPlayerDao()
                .insert(player)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        data.add(
                            Player(
                                it.toInt(),
                                player.name,
                                player.score
                            )
                        )
                        disposable = null
                        Toast.makeText(this, "Save to high-score list!", Toast.LENGTH_LONG)
                            .show()
                    },
                    {
                        Toast.makeText(this, "Failed to add new player!", Toast.LENGTH_LONG)
                            .show()
                    }
                )
        }
    }
}