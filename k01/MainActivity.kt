package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var myB:Button
    private lateinit var myT:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myB = findViewById(R.id.button)
        myT = findViewById(R.id.myT)
        myB.text = "送出"
    }


    fun onBtnClick(view: View){
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
        myT.text="收到!!"
    }
}