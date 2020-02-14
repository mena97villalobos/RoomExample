package com.mena97villalobos.roomexample.database

import androidx.room.*

@Entity(
    tableName = "book_table",
    foreignKeys = [ForeignKey(
        entity = Author::class,
        parentColumns = arrayOf("authorId"),
        childColumns = arrayOf("fkAuthor"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["fkAuthor"])]
)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val bookId: Long = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "fkAuthor")
    val fkAuthor: Long

)