package com.example.catsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsapp.data.Cat
import kotlinx.coroutines.launch

class CatsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Cat>>()
    val items: LiveData<List<Cat>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = CatsApiImpl.getListOfCats()
        }
    }
}