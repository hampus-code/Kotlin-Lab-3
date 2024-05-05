package com.hampuscode.lab_3.user


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hampuscode.lab_3.api.Book

@Entity(tableName = "users")
data class User(
    var userName: String,
    var password: String,
    //var bookList: MutableList<Book> = mutableListOf()
) {


    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    override fun toString(): String {
        return "Username: $userName, Password: $password, Id: $id"
    }

}