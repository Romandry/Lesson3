package ua.javabegin.examples.lesson3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*


// Описывается способ связи между данными и компонентом. В конструкторе передаем список строк
class MyRecyclerAdapter(var context: Context): RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    var eventListRecyclerAdp = mutableListOf<ResponseItem>()

    fun setEventListRecyclerAdapter(events: List<ResponseItem>) {
        this.eventListRecyclerAdp = events.toMutableList()

        notifyDataSetChanged()// ждем изменеий
    }

    // Класс содержит ссылки на все View в элементе item (recycleview_item.xml)
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView_1: TextView = itemView.textView1
        val cardView: CardView = itemView.cardview

    }

    // Берет разметку item (recycleview_item.xml) и "надувает" ее с помощью inflate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // создаем и надуваем шаблон
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return MyRecyclerAdapter.MyViewHolder(itemView) // передаем ViewHolder
    }

    // заполняем view item который уже находится в памяти
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val responceItem = eventListRecyclerAdp[position]
        holder.textView_1?.text = responceItem.cityName

        holder.cardView.setOnClickListener {
            Toast.makeText(context, responceItem.eventId, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int = eventListRecyclerAdp.size

    /*
    * когда создается первый item запускается onCreateViewHolder
    * создаем шаблон itemView
    * создается класс MyViewHolder с этим шаблоном
    *
    * в класс MyViewHolder передается view
    * заполняем поля
    *
    * как только запустилась функция onCreateViewHolder и елемент itemView создан и создан MyViewHolder
    * то запускается onBindViewHolder в который передается MyViewHolder
    *
    * */
}