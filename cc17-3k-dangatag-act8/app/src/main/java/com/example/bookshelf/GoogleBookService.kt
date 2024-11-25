import com.example.bookshelf.BookItem
import com.example.bookshelf.BookResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): Response<BookResponse>

    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") id: String): Response<BookItem>

    companion object {
        fun create(): GoogleBooksService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/volumes?q=jazz+history")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(GoogleBooksService::class.java)
        }
    }
}