package com.andreramon.demo.query

import com.andreramon.demo.GRAPHQL_ENDPOINT
import com.andreramon.demo.GRAPHQL_MEDIA_TYPE
import com.andreramon.demo.model.Author
import com.andreramon.demo.verifyData
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorQueryIT(@Autowired private val testClient: WebTestClient) {

    @Test
    fun testAuthorByIdQuery() {
        val query = "authorById"
        val data = Author(1, "Leo Tolstoy")

        testClient.post()
            .uri(GRAPHQL_ENDPOINT)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(GRAPHQL_MEDIA_TYPE)
            .bodyValue("query { $query(id: 1) { name } }")
            .exchange()
            .verifyData("$query.name", data.name!!)
    }
}
