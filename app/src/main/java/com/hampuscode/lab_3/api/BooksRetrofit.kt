package com.hampuscode.lab_3.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object BooksRetrofit {

    //https://openlibrary.org/search.json

    private const val BASE_URL = "https://openlibrary.org/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val bookApi: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }

    suspend fun fetchBook(query: String): Book {

        return suspendCoroutine { continuation ->

            val searchApi = bookApi.searchBook(query = query)
            searchApi.enqueue(object : Callback<Book> {

                override fun onResponse(call: Call<Book>, response: Response<Book>) {
                    println("API Response: ${response.body()}")
                    if (response.isSuccessful) {
                        val book = response.body()
                        if (book != null) {
                            continuation.resume(book)
                        } else {
                            continuation.resumeWithException(Exception("Unsuccessful response: ${response.code()}"))
                        }
                    }
                }

                override fun onFailure(call: Call<Book>, t: Throwable) {
                    println(t.message)
                }

            })
        }
    }
}