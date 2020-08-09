package com.andreramon.demo.repository

import com.andreramon.demo.model.Book
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface BookRepository : ReactiveCrudRepository<Book, Int> {
    fun findBooksByAuthorId(id: Int): Flux<Book>
}
