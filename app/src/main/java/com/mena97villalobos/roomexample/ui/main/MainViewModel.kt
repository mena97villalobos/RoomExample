package com.mena97villalobos.roomexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mena97villalobos.roomexample.database.Author
import com.mena97villalobos.roomexample.database.Book
import com.mena97villalobos.roomexample.database.DatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val database: DatabaseDao) : ViewModel() {


    private val _onBooksRetrieved = MutableLiveData<List<Book>>()
    val onBooksRetrieved: LiveData<List<Book>>
        get() = _onBooksRetrieved


    private val _onAuthorsRetrieved = MutableLiveData<List<Author>>()
    val onAuthorsRetrieved: LiveData<List<Author>>
        get() = _onAuthorsRetrieved


    fun getAllBooks() =
        viewModelScope.launch { getAllBooksAux() }


    private suspend fun getAllBooksAux() =
        withContext(Dispatchers.IO) {
            _onBooksRetrieved.postValue(database.getAllBooks())
        }


    fun getAllAuthors() =
        viewModelScope.launch { getAllAuthorsAux() }


    private suspend fun getAllAuthorsAux() =
        withContext(Dispatchers.IO) {
            _onAuthorsRetrieved.postValue(database.getAllAuthors())
        }

}