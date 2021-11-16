package com.example.homework_016.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework_016.App


@Database(entities = [TestEntity::class], version = 1, /*exportSchema = false*/)
abstract class TestDatabase : RoomDatabase() {

    abstract fun testDao(): TestDao

    companion object {
        val db by lazy {
            Room.databaseBuilder(
                App.appContext!!,
                TestDatabase::class.java,
                "test_table"
            ).build()
        }
    }


}