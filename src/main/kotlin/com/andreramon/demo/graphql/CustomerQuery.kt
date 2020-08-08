package com.andreramon.demo.graphql

import com.andreramon.demo.model.Customer
import com.andreramon.demo.service.CustomerService
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component
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