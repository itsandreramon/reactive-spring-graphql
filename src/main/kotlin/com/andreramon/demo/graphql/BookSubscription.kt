package com.andreramon.demo.graphql

import com.andreramon.demo.model.Book
import com.andreramon.demo.service.BookService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Subscription
import org.reactivestreams.Publisher
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.random.Random

@Component
class BookSubscription(
  private val bookService: BookService
) : Subscription {

  @GraphQLDescription("Returns a single book in a non-blocking way")
  fun bookById(id: Int): Mono<Book> {
    return bookService.findBookById(id)
  }

  @GraphQLDescription("Returns all books in a non-blocking way")
  fun allBooks(): Flux<Book> {
    return bookService.findAllBooks()
  }
}