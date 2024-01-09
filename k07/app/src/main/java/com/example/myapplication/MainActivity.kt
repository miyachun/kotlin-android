package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.example.myapplication.Country


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val countryName = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fromArrayOfJSONToModel()
    }


    private fun fromArrayOfJSONToModel(): Unit {

        val response = readFromAssets("country.json");

        val gson = Gson()
        val countryList: List<Country> = gson.fromJson(response, Array<Country>::class.java).toList()
        //binding.textView.text= countryList[0].toString()
        // val listView: ListView =binding.listview
        // val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryList)
        // listView.setAdapter(adapter)

        for (country: Country in countryList) {
            Log.d("fromArrayOfJSONToModel", "${country.name} , ${country.capital} \n")
            countryName.add(country.name)
        }
        val listView: ListView =binding.listview
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countryName)
        listView.setAdapter(adapter)
    }

    private fun readFromAssets(fileName: String): String {
        val bufferReader = application.assets.open(fileName).bufferedReader()
        return bufferReader.use {
            it.readText()
        }
    }



}
