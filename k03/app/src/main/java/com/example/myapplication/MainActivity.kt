package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val listView: ListView =binding.userlist
        val tv1: TextView =binding.tv1
        val players = arrayOf<String>("one", "two", "three", "four", "five", "six","seven","eight")
        val playerList = ArrayList<String>(listOf(*players))
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, playerList)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            tv1.text = "Delete - $selectedItem"
            arrayAdapter.remove(selectedItem)
            arrayAdapter.notifyDataSetChanged()
        }


    }

}







