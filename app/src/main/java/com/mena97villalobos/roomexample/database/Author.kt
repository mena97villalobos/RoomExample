package com.mena97villalobos.roomexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author_table")
data class Author (

    @PrimaryKey(autoGenerate = true)
    val authorId: Long = 0,

    @ColumnInfo(name = "name")
    val name: String

)