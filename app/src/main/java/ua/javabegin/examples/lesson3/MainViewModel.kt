package ua.javabegin.examples.lesson3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

// объявляем в конструкторе repository
class MainViewModel constructor(private val repository: MainRepository): ViewModel() {

    // Вместо enqueue используем Coroutine
    val eventList = liveData(Dispatchers.IO) {
        val response = repository.getAllEventsRepository() // делаем http запрос и получаем объект обвертку типа call
        emit(response)
    }

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