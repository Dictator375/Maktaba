package com.ElOuedUniv.maktaba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.ElOuedUniv.maktaba.data.repository.BookRepository
import com.ElOuedUniv.maktaba.presentation.screens.BookListScreen
import com.ElOuedUniv.maktaba.presentation.theme.MaktabaTheme
import com.ElOuedUniv.maktaba.presentation.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Manual Dependency Injection
        val bookRepository = BookRepository()
        val bookViewModelFactory = BookViewModelFactory(bookRepository)
        val bookViewModel = ViewModelProvider(this, bookViewModelFactory).get(BookViewModel::class.java)

        setContent {
            MaktabaTheme {
                BookListScreen(viewModel = bookViewModel)
            }
        }
    }
}
