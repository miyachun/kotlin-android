package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.tv1.text="hello kotlin"

    }


    fun onBtnClick(view: View) {
        var yourVote: String = ""
        var checkBoxChoices: String = ""
        val c1=binding.checkBox1
        val c2=binding.checkBox2
        val c3=binding.checkBox3
        val r1=binding.radioMale
        val r2=binding.radioFemale
        val e1=binding.editTextText

        if (r1.isChecked()) {
            yourVote += "male"+" ";}
        if (r2.isChecked()) {
            yourVote += "female"+" ";}

        if (c1.isChecked()) {
            checkBoxChoices += c1.getText().toString()+" ";}
        if (c2.isChecked()) {
            checkBoxChoices += c2.getText().toString()+" ";}
        if (c3.isChecked()) {
            checkBoxChoices += c3.getText().toString()+" ";}

        binding.myT.setText("name:"+e1.text+"\n"+"RO:"+yourVote+"\nCB:"+ checkBoxChoices)

    }

}
