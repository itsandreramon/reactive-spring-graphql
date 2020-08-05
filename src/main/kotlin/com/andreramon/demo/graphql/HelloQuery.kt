package com.andreramon.demo.graphql

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class HelloQuery : Query {
  fun hello() = "Hello"
}