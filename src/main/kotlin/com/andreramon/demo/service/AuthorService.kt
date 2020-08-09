package com.andreramon.demo.service

import com.andreramon.demo.model.Author
import com.andreramon.demo.repository.AuthorRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AuthorService(
    private val authorRepository: AuthorRepository
) {

    fun findAuthorById(id: Int): Mono<Author> {
        return authorRepository.findById(id)
    }

    fun findAll(): Flux<Author> {
        return authorRepository.findAll()
    }
}
