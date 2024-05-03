package com.hampuscode.lab_3.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("/search.json")
    fun searchBook(@Query("q") query: String): Call<Book>
}