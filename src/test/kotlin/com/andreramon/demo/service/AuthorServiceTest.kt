package com.andreramon.demo.service

import com.andreramon.demo.model.Author
import com.andreramon.demo.repository.AuthorRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

class AuthorServiceTest {

    private val authorRepository = mockk<AuthorRepository>()
    private val authorService = AuthorService(authorRepository)

    @BeforeEach
    fun setup() {
        every {
            authorRepository.findById(1)
        } returns Mono.just(Author(1, "Leo Tolstoy"))
    }

    @Test
    fun testFindAuthorById() {
        StepVerifier.create(authorService.findAuthorById(1))
            .expectNextMatches { it == Author(1, "Leo Tolstoy") }
            .expectComplete()
            .verify()
    }
}
