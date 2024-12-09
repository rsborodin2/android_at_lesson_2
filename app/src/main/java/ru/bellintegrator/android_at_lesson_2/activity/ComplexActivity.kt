package ru.bellintegrator.android_at_lesson_2.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.bellintegrator.android_at_lesson_2.R

class ComplexActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complex)

        // Настройка RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter()
        recyclerView.adapter = adapter

        // Кнопка 1
        findViewById<Button>(R.id.button1).setOnClickListener {
            Toast.makeText(this, "Button 1 clicked!", Toast.LENGTH_SHORT).show()
        }

        // Кнопка 2
        findViewById<Button>(R.id.button2).setOnClickListener {
            Toast.makeText(this, "Button 2 clicked!", Toast.LENGTH_SHORT).show()
        }

        // Кнопка 3
        findViewById<Button>(R.id.button3).setOnClickListener {
            Toast.makeText(this, "Button 3 clicked!", Toast.LENGTH_SHORT).show()
        }

        // Кнопка 4
        findViewById<Button>(R.id.button4).setOnClickListener {
            Toast.makeText(this, "Button 4 clicked!", Toast.LENGTH_SHORT).show()
        }

        // Кнопка 5
        findViewById<Button>(R.id.button5).setOnClickListener {
            Toast.makeText(this, "Button 5 clicked!", Toast.LENGTH_SHORT).show()
        }

        // Кнопка 6
        findViewById<Button>(R.id.button6).setOnClickListener {
            Toast.makeText(this, "Button 6 clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    // Адаптер для RecyclerView
    inner class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
        private val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView: TextView = itemView.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
        ): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(
            holder: ViewHolder,
            position: Int,
        ) {
            holder.textView.text = items[position]
        }

        override fun getItemCount(): Int {
            return items.size
        }
    }
}
