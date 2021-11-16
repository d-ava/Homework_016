package com.example.homework_016.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

@Dao
interface TestDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(vararg item: TestEntity)
   // suspend fun insertItem(item: TestEntity)


    @Query("SELECT * FROM test_table")
    fun getAll(): Flow<List<TestEntity>>
   // fun getAll(): LiveData<List<TestEntity>>


}