package com.ElOuedUniv.maktaba.domain.usecase

import com.ElOuedUniv.maktaba.data.repository.BookRepository

class GetTotalPagesUseCase(private val bookRepository: BookRepository) {
    operator fun invoke(): Int {
        return bookRepository.getAllBooks().sumOf { it.nbPages }
    }
}
