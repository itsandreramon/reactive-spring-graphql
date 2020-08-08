package com.andreramon.demo.graphql

import com.andreramon.demo.model.Book
import com.andreramon.demo.service.BookService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.adapter.rxjava.toFlowable
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

@Component
class BookQuery(
  private val bookService: BookService
) : Query {

  fun bookById(id: Int): CompletableFuture<Book> {
    return bookService.findBookById(id)
      .toFuture()
  }

  fun booksByAuthorId(id: Int): CompletableFuture<List<Book>> {
    return bookService.findBooksByAuthorId(id)
      .collectList()
      .toFuture()
  }

  fun allBooks(): CompletableFuture<List<Book>> {
    return bookService.findAllBooks()
      .collectList()
      .toFuture()
  }
}