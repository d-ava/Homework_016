package com.example.homework_016.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.homework_016.db.TestDao
import com.example.homework_016.db.TestDatabase
import com.example.homework_016.db.TestEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var testDao: TestDao = TestDatabase.db.testDao()


  //  private val _readItems: LiveData<List<TestEntity>> = testDao.getAll()
  //  val readItems: LiveData<List<TestEntity>> get()=_readItems

  //  private val _readItems: Flow<List<TestEntity>> = testDao.getAll()
  //  val readItems: Flow<List<TestEntity>> = _readItems

    /*
    private val _readItems= MutableSharedFlow<List<TestEntity>>()
    val readItems: SharedFlow<List<TestEntity>> = _readItems
*/



   // val readItems: LiveData<List<TestEntity>> = testDao.getAll().asLiveData()

    val readItems: Flow<List<TestEntity>> = testDao.getAll()




}