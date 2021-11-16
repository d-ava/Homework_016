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


    @Query("SELECT * FROM test_table")
    fun getAll(): Flow<List<TestEntity>>

    @Query("DELETE FROM test_table WHERE title = :title")
    suspend fun deleteItem(title: String)

    @Query("UPDATE test_table SET title = :title, description = :description, url = :url WHERE title = :title")
    suspend fun updateItem(title: String, description: String, url: String): Int


}