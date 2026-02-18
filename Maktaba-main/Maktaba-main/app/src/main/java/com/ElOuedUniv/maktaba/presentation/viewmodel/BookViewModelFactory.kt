package com.ElOuedUniv.maktaba.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ElOuedUniv.maktaba.data.repository.BookRepository
import com.ElOuedUniv.maktaba.domain.usecase.GetBookByIsbnUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetBooksWithMoreThan400PagesUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetTotalBooksUseCase
import com.ElOuedUniv.maktaba.domain.usecase.GetTotalPagesUseCase

class BookViewModelFactory(private val bookRepository: BookRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            return BookViewModel(
                getBooksUseCase = GetBooksUseCase(bookRepository),
                getBookByIsbnUseCase = GetBookByIsbnUseCase(bookRepository),
                getTotalBooksUseCase = GetTotalBooksUseCase(bookRepository),
                getTotalPagesUseCase = GetTotalPagesUseCase(bookRepository),
                getBooksWithMoreThan400PagesUseCase = GetBooksWithMoreThan400PagesUseCase(bookRepository)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
