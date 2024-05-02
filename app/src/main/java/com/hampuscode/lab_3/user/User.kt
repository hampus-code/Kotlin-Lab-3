package com.hampuscode.lab_3.user


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User(
    var userName: String,
    var password: String
) {


    @PrimaryKey(autoGenerate = true)
    var id: Long? = null


}