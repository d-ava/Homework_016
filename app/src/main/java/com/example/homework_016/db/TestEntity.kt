package com.example.homework_016.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity (tableName = "test_table")
data class TestEntity(
    val title: String,
    val description: String,
    val url: String

): Parcelable

{
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true) var id:Int =0
}
