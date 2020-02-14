package com.mena97villalobos.roomexample.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mena97villalobos.roomexample.database.DatabaseDao
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory (private val dataSource: DatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(dataSource) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}