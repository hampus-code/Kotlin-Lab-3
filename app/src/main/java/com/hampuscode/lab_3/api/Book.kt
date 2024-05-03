package com.hampuscode.lab_3.api

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("docs") val docs: List<BookItem>
)

data class BookItem(
    @SerializedName("title") val title: String,
    @SerializedName("author_name") val authorName: List<String>,
    @SerializedName("publisher") val publisher: List<String>,
    @SerializedName("publish_year") val publishYear: List<Int>,
    //@SerializedName("cover_edition_key") val coverEditionKey: String?
    //ratings_average
)
