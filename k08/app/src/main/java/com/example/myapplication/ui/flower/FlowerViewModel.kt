package com.example.myapplication.ui.flower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlowerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is flower Fragment"
    }
    val text: LiveData<String> = _text
}