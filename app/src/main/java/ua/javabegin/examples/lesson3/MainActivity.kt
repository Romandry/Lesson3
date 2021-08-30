package ua.javabegin.examples.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ua.javabegin.examples.lesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MyRecyclerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // для создание viewModel используется спец фабрика
        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this) // вариант расположения элементов списка

        binding.recyclerView.adapter = adapter // Как будет выглядеть один элемент списка

        // подписываемся на LiveData bookList
        viewModel.bookList.observe(this, {
            adapter.setBookListRecyclerAdapter(it.firstObject.responseItem)
        })

        // Главный вызов для получения данных
//        viewModel.getAllBooksViewModel()


    }
}