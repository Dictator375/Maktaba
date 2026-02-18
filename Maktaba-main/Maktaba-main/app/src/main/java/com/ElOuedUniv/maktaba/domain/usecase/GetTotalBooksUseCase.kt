package com.ElOuedUniv.maktaba.domain.usecase

import com.ElOuedUniv.maktaba.data.repository.BookRepository

class GetTotalBooksUseCase(private val bookRepository: BookRepository) {
    operator fun invoke(): Int {
        return bookRepository.getAllBooks().size
    }
}
