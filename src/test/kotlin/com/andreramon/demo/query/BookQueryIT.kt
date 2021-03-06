package com.andreramon.demo.query

import com.andreramon.demo.GRAPHQL_ENDPOINT
import com.andreramon.demo.GRAPHQL_MEDIA_TYPE
import com.andreramon.demo.model.Book
import com.andreramon.demo.verifyData
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
@TestInstance(PER_CLASS)
class BookQueryIT(@Autowired private val testClient: WebTestClient) {

    @Test
    fun testBookByIdQuery() {
        val query = "bookById"
        val data = Book(1, "Anna Karenina", 1)

        testClient.post()
            .uri(GRAPHQL_ENDPOINT)
            .accept(APPLICATION_JSON)
            .contentType(GRAPHQL_MEDIA_TYPE)
            .bodyValue("query { $query(id: 1) { name } }")
            .exchange()
            .verifyData("$query.name", data.name!!)
    }
}
