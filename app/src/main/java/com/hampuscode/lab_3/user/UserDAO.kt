package com.hampuscode.lab_3.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    // Define Queries & Abstract-Methods
    @Upsert
    fun insertOrUpdateUser(user: User)

    //Delete user by ID
    @Delete
    fun deleteUserById(user: User)



    @Query("SELECT * FROM users")
    fun findAllUsers(): Flow<List<User>>

}