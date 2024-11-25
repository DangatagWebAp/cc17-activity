package com.example.bookshelf

import GoogleBooksService
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: BookViewModel
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GoogleBooksService::class.java)
        val repository = BookRepository(service)
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(BookViewModel::class.java)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        adapter = BookAdapter(emptyList(), emptyList())
        recyclerView.adapter = adapter


        viewModel.books.observe(this, { books ->

            val thumbnails = books.map {
                it.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://") ?: ""
            }
            adapter = BookAdapter(books, thumbnails)
            recyclerView.adapter = adapter // Set the new adapter
        })

        viewModel.fetchBooks("jazz history")
    }
}