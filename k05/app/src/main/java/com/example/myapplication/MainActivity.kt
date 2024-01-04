package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.FlowerAdapter


class MainActivity : AppCompatActivity() {
    val flowerList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flowerList.add("item01")
        flowerList.add("item02")
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = FlowerAdapter(flowerList)

    }



    fun onClickFab(view: View) {
       // Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        showDialog(this, "Alert Dialog", "輸入文字新增內容")
    }

    private fun showDialog(mainActivity: MainActivity, s: String, s1: String) {
        val builder = AlertDialog.Builder(this)
        val  input = EditText(this);

        builder.setTitle(title)
        builder.setView(input)

        builder.setMessage(s1)
        builder.setPositiveButton("OK") { _, _ ->
            Toast.makeText(this,"You press OK button",Toast.LENGTH_SHORT).show()
            flowerList.add(input.text.toString())
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(this,"You press Cancel button",Toast.LENGTH_SHORT).show()
        }
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.show()
    }
}


