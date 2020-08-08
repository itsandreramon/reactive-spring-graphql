package com.andreramon.demo.graphql

import com.andreramon.demo.model.Order
import com.andreramon.demo.service.OrderService
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class OrderQuery(
  private val orderService: OrderService
) : Query {

  fun orderById(id: Int): CompletableFuture<Order> {
    return orderService.findOrderById(id)
      .toFuture()
  }

  fun orderByCustomerId(id: Int): CompletableFuture<List<Order>> {
    return orderService.findOrderByCustomerId(id)
      .collectList()
      .toFuture()
  }

  fun allOrders(): CompletableFuture<List<Order>> {
    return orderService.findAll()
      .collectList()
      .toFuture()
  }
}