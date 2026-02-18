package com.ElOuedUniv.maktaba.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.domain.usecase.GetBookByIsbnUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksWithMoreThan400PagesUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetTotalBooksUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetTotalPagesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val getBookByIsbnUseCase: GetBookByIsbnUseCase,
    private val getTotalBooksUseCase: GetTotalBooksUseCase,
    private val getTotalPagesUseCase: GetTotalPagesUseCase,
    private val getBooksWithMoreThan400PagesUseCase: GetBooksWithMoreThan400PagesUseCase
) : ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _foundBook = MutableStateFlow<Book?>(null)
    val foundBook: StateFlow<Book?> = _foundBook.asStateFlow()

    init {
        loadBooks()
    }

    private fun loadBooks() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _books.value = getBooksUseCase()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun refreshBooks() {
        loadBooks()
    }

    fun getBookByIsbn(isbn: String) {
        viewModelScope.launch {
            _foundBook.value = getBookByIsbnUseCase(isbn)
        }
    }

    fun getTotalBooks(): Int {
        return getTotalBooksUseCase()
    }

    fun getTotalPages(): Int {
        return getTotalPagesUseCase()
    }

    fun getBooksWithMoreThan400Pages(): List<Book> {
        return getBooksWithMoreThan400PagesUseCase()
    }
}
