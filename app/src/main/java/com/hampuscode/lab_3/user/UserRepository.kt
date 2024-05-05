package com.hampuscode.lab_3.user

import com.hampuscode.lab_3.api.Book
import com.hampuscode.lab_3.database.MyDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class UserRepository(
    private val myDatabase: MyDatabase,
    private val coroutineScope: CoroutineScope
) {

    // SAVE USER
    fun insertOrUpdateUser(user: User) {
        myDatabase.userDao().insertOrUpdateUser(user)
    }

    // DELETE USER BY ID
    fun deleteUserById(user: User) {

        myDatabase.userDao().deleteUserById(user)
    }

    // Find all users
    fun findAllUsers(): Flow<List<User>> {
        return myDatabase.userDao().findAllUsers()
    }


    fun performDatabaseOperation(dispatcher: CoroutineDispatcher, databaseOperation: suspend () -> Unit) {
        coroutineScope.launch(dispatcher) {
            databaseOperation()
        }
    }

}