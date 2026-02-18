package com.ElOuedUniv.maktaba.domain.usecase

import com.ElOuedUniv.maktaba.data.model.Book
import com.ElOuedUniv.maktaba.data.repository.BookRepository

class GetBooksWithMoreThan400PagesUseCase(private val bookRepository: BookRepository) {
    operator fun invoke(): List<Book> {
        return bookRepository.getAllBooks().filter { it.nbPages > 400 }
    }
}
