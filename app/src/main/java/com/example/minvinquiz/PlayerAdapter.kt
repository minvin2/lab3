package com.example.minvinquiz

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter( private val data: MutableList<Player>

) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>()
{

    class PlayerViewHolder(v: View) : RecyclerView.ViewHolder(v)
    {
        var nameField=v.findViewById<TextView>(R.id.text_number)
        var scoreField=v.findViewById<TextView>(R.id.text_score)

    }


    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        var player = data[position]
        holder.nameField.text=player.name
        holder.scoreField.text=player.score.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_player_item,parent,false)

        return PlayerViewHolder(v)
    }

}