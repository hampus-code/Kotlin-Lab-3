package com.hampuscode.lab_3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hampuscode.lab_3.api.Book
import com.hampuscode.lab_3.user.User
import com.hampuscode.lab_3.user.UserDAO


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
                )
                    //Handle migration from version 1 to 2

                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}