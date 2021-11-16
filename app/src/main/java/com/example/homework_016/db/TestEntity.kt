package com.example.homework_016.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "test_table")
data class TestEntity(
    val title: String,
    val description: String,
    val url: String

){
    @PrimaryKey(autoGenerate = true) var id:Int =0
}
