package com.andreramon.demo.repository

import com.andreramon.demo.model.Author
import com.andreramon.demo.model.Book
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AuthorRepository : ReactiveCrudRepository<Author, Int>