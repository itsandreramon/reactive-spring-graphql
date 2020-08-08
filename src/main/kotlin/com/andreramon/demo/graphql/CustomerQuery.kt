package com.andreramon.demo.graphql

import com.andreramon.demo.model.Author
import com.andreramon.demo.model.Book
import com.andreramon.demo.model.Customer
import com.andreramon.demo.service.AuthorService
import com.andreramon.demo.service.BookService
import com.andreramon.demo.service.CustomerService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

@Component
class CustomerQuery(
  private val customerService: CustomerService
) : Query {

  fun customerById(id: Int): CompletableFuture<Customer> {
    return customerService.findCustomerById(id)
      .toFuture()
  }

  fun allCustomers(): CompletableFuture<List<Customer>> {
    return customerService.findAll()
      .collectList()
      .toFuture()
  }
}