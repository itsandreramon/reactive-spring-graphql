package com.andreramon.demo.graphql

import com.andreramon.demo.model.Order
import com.andreramon.demo.service.OrderService
import com.expediagroup.graphql.spring.operations.Subscription
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class OrderSubscription(
  private val orderService: OrderService
) : Subscription {

  fun orderById(id: Int): Mono<Order> {
    return orderService.findOrderById(id)
  }

  fun orderByCustomerId(id: Int): Flux<Order> {
    return orderService.findOrderByCustomerId(id)
  }

  fun allOrders(): Flux<Order> {
    return orderService.findAll();
  }
}