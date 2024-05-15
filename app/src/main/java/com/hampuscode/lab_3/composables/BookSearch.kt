package com.hampuscode.lab_3.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hampuscode.lab_3.api.Book
//import coil.compose.AsyncImage
import com.hampuscode.lab_3.viewModel.BookViewModel
import com.hampuscode.lab_3.api.BookItem
import com.hampuscode.lab_3.ui.components.CustomButton


@Composable
fun BookItems(book: BookItem) {

    Column {
        Text(text = "Title: ${book.title}", modifier = Modifier.padding(10.dp))
        Text(text = "Author: ${book.authorName}", modifier = Modifier.padding(10.dp))

    }
}

@Composable
fun BookCard(viewModel: BookViewModel = viewModel()) {
    var isClicked by remember { mutableStateOf(false) }

    //Remembering the typed in word, or typed in book, when screen rotates
    var query by rememberSaveable { mutableStateOf("") }



    Column {
        OutlinedTextField(
            value = query,
            onValueChange = { newQuery ->
                query = newQuery
            },
            label = { Text("Search Book") }
        )

        CustomButton(text = "Search",
            onClick = {
                isClicked = true
                viewModel.fetchBook(query) // Pass the search query to fetchBook
            },
            modifier = Modifier.padding(bottom = 16.dp).align(Alignment.CenterHorizontally)
        )


        if (isClicked) {
            val books by viewModel.bookUiState


            // Display books here if available
            books?.docs?.let { bookList ->
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    for (book in bookList) {

                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 6.dp
                            ),
                            modifier = Modifier
                                .size(width = 300.dp, height = 100.dp)
                                .padding(4.dp)
                        ) {
                            BookItems(book)

                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Books() {
    val viewModel: BookViewModel = viewModel()
    BookCard(viewModel = viewModel)
}