package com.andreramon.demo.service

import com.andreramon.demo.model.Book
import com.andreramon.demo.repository.BookRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun findBookById(id: Int): Mono<Book> {
        return bookRepository.findById(id)
    }

    fun findBooksByAuthorId(id: Int): Flux<Book> {
        return bookRepository.findBooksByAuthorId(id)
    }

    fun findAllBooks(): Flux<Book> {
        return bookRepository.findAll()
    }
}
