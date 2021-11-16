package com.example.homework_016.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_016.db.TestDao
import com.example.homework_016.db.TestDatabase
import com.example.homework_016.db.TestEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddViewModel: ViewModel() {

    private var testDao: TestDao = TestDatabase.db.testDao()



    fun addItem(item: TestEntity) {

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                testDao.insertItem(TestEntity("title", "description some text", "https://cdn3.photostockeditor.com/t/0708/toy-selective-focus-photography-of-two-white-lego-minifigures-lego-lego-image.jpg"))
                testDao.insertItem(item)
            }

        }


    }

}