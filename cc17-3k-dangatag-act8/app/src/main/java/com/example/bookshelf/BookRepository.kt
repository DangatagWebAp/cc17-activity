package com.example.bookshelf

import GoogleBooksService
import retrofit2.Response

class BookRepository(private val service: GoogleBooksService) {
    suspend fun searchBooks(query: String): List<BookItem>? {
        val response = service.searchBooks(query)
        return if (response.isSuccessful) {
            response.body()?.items
        } else {
            null
        }
    }

    suspend fun getBookDetails(id: String): Response<BookItem> {
        return service.getBookDetails(id)
    }
}