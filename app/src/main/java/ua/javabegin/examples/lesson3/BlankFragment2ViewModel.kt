package ua.javabegin.examples.lesson3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class BlankFragment2ViewModel: ViewModel() {

    var repository: MainRepository = MainRepository()
    val eventItem = liveData(Dispatchers.IO) {
        val response = repository.getEventRepository(7839)
        emit(response)
    }
}