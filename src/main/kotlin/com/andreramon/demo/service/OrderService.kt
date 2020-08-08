package com.andreramon.demo.service

import com.andreramon.demo.model.Order
import com.andreramon.demo.repository.OrderRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OrderService(
  private val orderRepository: OrderRepository
) {

  fun findOrderById(id: Int): Mono<Order> {
    return orderRepository.findById(id)
  }

  fun findOrderByCustomerId(id: Int): Flux<Order> {
    return orderRepository.findOrderByCustomerId(id)
  }

  fun findAll(): Flux<Order> {
    return orderRepository.findAll();
  }
}