package com.andreramon.demo.graphql

import com.andreramon.demo.model.Author
import com.andreramon.demo.model.Book
import com.andreramon.demo.model.Customer
import com.andreramon.demo.service.AuthorService
import com.andreramon.demo.service.BookService
import com.andreramon.demo.service.CustomerService
import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CustomerSubscription(
  private val customerService: CustomerService
) : Subscription {

  fun customerById(id: Int): Mono<Customer> {
    return customerService.findCustomerById(id)
  }

  fun allCustomers(): Flux<Customer> {
    return customerService.findAll()
  }
}