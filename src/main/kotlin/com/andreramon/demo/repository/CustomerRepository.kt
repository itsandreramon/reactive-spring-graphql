package com.andreramon.demo.repository

import com.andreramon.demo.model.Customer
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CustomerRepository : ReactiveCrudRepository<Customer, Int>
