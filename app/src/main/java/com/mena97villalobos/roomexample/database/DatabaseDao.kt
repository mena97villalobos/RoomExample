package com.mena97villalobos.roomexample.database

import androidx.room.*

@Dao
interface DatabaseDao {

    @Insert
    fun insertBool(book: Book)

    @Insert
    fun insertAuthor(author: Author)

    @Delete
    fun deleteBook(book: Book)

    @Delete
    fun deleteAuthor(author: Author)

    @Update
    fun updateBook(book: Book)

    @Update
    fun updateAuthor(author: Author)

    @Query("SELECT * FROM book_table")
    fun getAllBooks(): List<Book>

    @Query("SELECT * FROM author_table")
    fun getAllAuthors(): List<Author>

    @Query("SELECT * FROM book_table WHERE bookId = :bookId LIMIT 1")
    fun getBookById(bookId: Int): Book

    @Query("SELECT * FROM author_table WHERE authorId = :authorId LIMIT 1")
    fun getAuthorById(authorId: Int): Author

}