package com.hampuscode.lab_3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hampuscode.lab_3.user.User
import com.hampuscode.lab_3.user.UserDAO

// TODO - IF WE CHANGE DATABASE + RUN APP, Versions can cause errors
@Database(entities = [User::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    // Our Queries
    abstract fun userDao(): UserDAO

    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "lab-3-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}