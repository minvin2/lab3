package com.example.minvinquiz

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PlayerDao
{
    @Insert
    fun insert(player: Player) : Single<Long>

    @Query("SELECT * FROM player")
    fun getAllPlayers() : Single<List<Player>>


}