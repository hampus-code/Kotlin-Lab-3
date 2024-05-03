package com.hampuscode.lab_3.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hampuscode.lab_3.api.Book
import com.hampuscode.lab_3.api.BooksRetrofit
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private val _bookUiState = mutableStateOf<Book?>(null)
    var bookUiState : State<Book?> = _bookUiState


    fun fetchBook(query: String) {
        viewModelScope.launch {
            try {
                val books = BooksRetrofit.fetchBook(query)
                _bookUiState.value = books
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}