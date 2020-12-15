package com.example.minvinquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_high_score_history.*

class HighScoreHistoryActivity : AppCompatActivity() {

    lateinit var listView: RecyclerView
    lateinit var adapter: PlayerAdapter

    var data = mutableListOf<Player>()
    lateinit var database: AppDatabase
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score_history)
        database = AppDatabase.getInstance(this)!!
        listView=findViewById<RecyclerView>(R.id.list)
        listView.layoutManager = LinearLayoutManager(this)
        adapter = PlayerAdapter(data)
        listView.adapter= adapter
        getPlayers()

    }

        fun getPlayers()
    {
        disposable = database?.getPlayerDao()
            ?.getAllPlayers()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    data.clear()
                    if(!it.isNullOrEmpty())
                    {
                        data.addAll(it)
                    }
                    adapter.notifyDataSetChanged()
                    disposable = null
                },
                {
                    Toast.makeText(this, "Error retrieving players!", Toast.LENGTH_LONG).show()
                }
            )
    }


}

