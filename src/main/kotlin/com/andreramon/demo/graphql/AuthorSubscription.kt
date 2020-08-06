package com.andreramon.demo.graphql

import com.andreramon.demo.model.Author
import com.andreramon.demo.model.Book
import com.andreramon.demo.service.AuthorService
import com.andreramon.demo.service.BookService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class AuthorSubscription(
  private val authorService: AuthorService
) : Subscription {

  fun authorById(id: Int): Mono<Author> {
    return authorService.findAuthorById(id)
  }

  fun allAuthors(): Flux<Author> {
    return authorService.findAll()
  }
}