package com.andreramon.demo.service

import com.andreramon.demo.model.Author
import com.andreramon.demo.model.Book
import com.andreramon.demo.model.Customer
import com.andreramon.demo.model.Order
import com.andreramon.demo.repository.AuthorRepository
import com.andreramon.demo.repository.BookRepository
import com.andreramon.demo.repository.CustomerRepository
import com.andreramon.demo.repository.OrderRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AuthorService(
  private val authorRepository: AuthorRepository
) {

  fun findAuthorById(id: Int): Mono<Author> {
    return authorRepository.findById(id)
  }

  fun findAll(): Flux<Author> {
    return authorRepository.findAll()
  }
}