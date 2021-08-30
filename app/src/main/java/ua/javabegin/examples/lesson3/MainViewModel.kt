package ua.javabegin.examples.lesson3










import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// объявляем в конструкторе repository
class MainViewModel constructor(private val repository: MainRepository): ViewModel() {

    val bookList = liveData(Dispatchers.IO) {
        val response = repository.getAllBooksRepository()
        emit(response)
    }

//    fun getAllBooksViewModel() {

//        val response = repository.getAllBooksRepository() // делаем http запрос и получаем объект обвертку типа call

//        response.enqueue(object: Callback<Book> { // получаем и обрабатываем ответ удача / неудача
//            override fun onResponse(call: Call<Book>, response: Response<Book>) {
//                println(response.body())
//                bookList.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<Book>, t: Throwable) {
//                println(t.message)
//            }
//        })
//    }

}