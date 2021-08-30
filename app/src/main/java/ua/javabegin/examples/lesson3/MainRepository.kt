package ua.javabegin.examples.lesson3

// создаем repository и в конструкторе  вызываем retrofit
// что бы не делать RetrofitService.getInstance().getBooks().enqueue(....)
// а вызвать val response = repository.getAllEvents() который и вернет retrofitService.getBooks()
// в итоге вызов будет response.enqueue(...)
class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllBooksRepository() = retrofitService.getBooksRetrofitService()
}