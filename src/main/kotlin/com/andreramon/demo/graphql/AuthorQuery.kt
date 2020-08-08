package com.andreramon.demo.graphql

import com.andreramon.demo.model.Author
import com.andreramon.demo.model.Book
import com.andreramon.demo.service.AuthorService
import com.andreramon.demo.service.BookService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

@Component
class AuthorQuery(
  private val authorService: AuthorService
) : Query {

  fun authorById(id: Int): CompletableFuture<Author> {
    return authorService.findAuthorById(id)
      .toFuture()
  }

  fun allAuthors(): CompletableFuture<List<Author>> {
    return authorService.findAll()
      .collectList()
      .toFuture()
  }
}