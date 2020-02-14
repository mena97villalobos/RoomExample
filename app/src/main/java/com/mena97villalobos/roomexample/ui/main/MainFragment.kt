package com.mena97villalobos.roomexample.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mena97villalobos.roomexample.R
import com.mena97villalobos.roomexample.database.AppDatabase

class MainFragment : Fragment() {

    private val viewModelFactory =
        MainViewModelFactory(AppDatabase.getInstance(activity!!.application).databaseDao)
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setupObservers()

        viewModel.getAllAuthors()
        viewModel.getAllBooks()

        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    private fun setupObservers() {
        viewModel.onAuthorsRetrieved.observe(viewLifecycleOwner, Observer {
            // TODO do something with data
        })

        viewModel.onBooksRetrieved.observe(viewLifecycleOwner, Observer {
            // TODO do something with data
        })
    }

}