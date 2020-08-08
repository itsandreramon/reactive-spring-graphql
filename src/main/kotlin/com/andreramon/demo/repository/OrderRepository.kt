package com.andreramon.demo.repository

import com.andreramon.demo.model.Order
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface OrderRepository : ReactiveCrudRepository<Order, Int> {
  fun findOrderByCustomerId(id: Int): Flux<Order>
}