package com.example.bookshelf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    private val _books = MutableLiveData<List<BookItem>>()
    val books: LiveData<List<BookItem>> get() = _books

    private val _thumbnails = MutableLiveData<List<String?>>()
    val thumbnails: LiveData<List<String?>> get() = _thumbnails

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            val booksList = repository.searchBooks(query)
            if (booksList != null) {
                val thumbnailUrls = fetchBookDetails(booksList)
                _books.value = booksList
                _thumbnails.value = thumbnailUrls
            }
        }
    }

    private suspend fun fetchBookDetails(books: List<BookItem>): List<String?> {
        val thumbnails = mutableListOf<String?>()
        for (book in books) {
            val response = repository.getBookDetails(book.id)
            if (response.isSuccessful) {
                val imageUrl = response.body()?.volumeInfo?.imageLinks?.thumbnail?.replace("http:", "https:")
                thumbnails.add(imageUrl)
            } else {
                thumbnails.add(null)
            }
        }
        return thumbnails
    }
}