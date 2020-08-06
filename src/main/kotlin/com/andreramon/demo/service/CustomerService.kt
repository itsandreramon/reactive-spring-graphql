package com.andreramon.demo.service

import com.andreramon.demo.model.Book
import com.andreramon.demo.model.Customer
import com.andreramon.demo.model.Order
import com.andreramon.demo.repository.BookRepository
import com.andreramon.demo.repository.CustomerRepository
import com.andreramon.demo.repository.OrderRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CustomerService(
  private val customerRepository: CustomerRepository
) {

  fun findCustomerById(id: Int): Mono<Customer> {
    return customerRepository.findById(id)
  }

  fun findAll(): Flux<Customer> {
    return customerRepository.findAll()
  }
}