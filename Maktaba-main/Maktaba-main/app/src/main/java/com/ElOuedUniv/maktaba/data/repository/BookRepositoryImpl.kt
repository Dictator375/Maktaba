package com.ElOuedUniv.maktaba.data.repository

import com.ElOuedUniv.maktaba.data.model.Book

class BookRepositoryImpl : BookRepository() {

    private val booksList = listOf(
        Book(isbn = "978-0-13-468599-1", title = "Clean Code", nbPages = 464),
        Book(isbn = "978-0201616224", title = "The Pragmatic Programmer", nbPages = 352),
        Book(isbn = "978-0201633610", title = "Design Patterns", nbPages = 416),
        Book(isbn = "978-0134757599" , title = "Refactoring", nbPages = 448),
        Book(isbn = "978-0596007126", title = "Head First Design Patterns", nbPages = 692),
        Book(isbn = "978-0262033848", title = "Introduction to Algorithms", nbPages = 1292 ),
        Book(isbn = "978-0137081073", title = "The Clean Coder", nbPages = 256),
        Book(isbn = "978-1098166304", title = "AI Engineering", nbPages = 532),
        Book(isbn = "978-0134494166", title = "Clean Architecture: A Guid", nbPages = 432),
        Book(isbn = "978-1098107963", title = "Designing Machine Learning Systems", nbPages = 386)


    )

    override fun getAllBooks(): List<Book> {
        return booksList
    }

    override fun getBookByIsbn(isbn: String): Book? {
        return booksList.find { it.isbn == isbn }
    }
}
