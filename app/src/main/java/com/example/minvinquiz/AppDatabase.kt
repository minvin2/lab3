package com.example.minvinquiz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Player::class), version = 1,exportSchema = false)
abstract class AppDatabase() : RoomDatabase()
{
    abstract fun getPlayerDao() : PlayerDao

    companion object
    {
        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase?
        {
            if(instance == null)
            {
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,
                    "manodatabase.db").build()
            }
            return instance
        }
    }
}