package ua.javabegin.examples.lesson3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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
        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository()))
            .get(MainViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this) // вариант расположения элементов списка

        binding.recyclerView.adapter = adapter // Как будет выглядеть один элемент списка

        // подписываемся на LiveData eventList
        viewModel.eventList.observe(this, {
            adapter.setEventListRecyclerAdapter(it.firstObject.responseItem)
        })

        // Главный вызов для получения данных
        // не нужен, т.к. вызов идет в Coroutine
//        viewModel.getAllBooksViewModel()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> startActivity(Intent(this, MenuActivity::class.java))
            R.id.save_settings -> Toast.makeText(this,"Save Setting", Toast.LENGTH_SHORT).show()
            R.id.open_settings -> Toast.makeText(this,"Option Setting", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}