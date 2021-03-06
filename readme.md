[![codecov](https://codecov.io/gh/itsandreramon/reactive-spring-graphql/branch/main/graph/badge.svg)](https://codecov.io/gh/itsandreramon/reactive-spring-graphql)

# Reactive Spring GraphQL
An example project showcasing a simple service which serves data about famous books.

### Define your GraphQL queries
```kotlin
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class AuthorQuery(
    private val authorService: AuthorService
) : Query {

    fun authorById(id: Int): CompletableFuture<Author> {
        return authorService.findAuthorById(id)
            .toFuture()
    }
}

data class Author(val id: Int, val name: String?)
```

### Let GraphQL Kotlin generate a type-safe schema for you
```graphql
schema {
    query: Query
}

type Author {
    id: Int!
    name: String
}

type Query {
    authorById(id: Int!): Author!
}
```

### Send a query to your GraphQL endpoint
```graphql
{
  authorById(id: 1) {
    name
  }
}
```

### How to run the sample
1. Build a Docker image using Spring Boot's Buildpack support
```
$ ./gradlew bootBuildImage --imageName=itsandreramon/spring
```

2. Make sure the corresponding itsandreramon/spring image has been built
```
$ docker images -a
```
3. Run Docker Compose
```
$ docker-compose up
```
4. Make sure everything is running correctly
```
$ docker-compose ps
```
5. Access PostgreSQL to make changes according to your needs (e.g. via CLI)
```
$ docker exec -it database psql -U postgres
```

### Default routes
Your newly created GraphQL server starts up with following preconfigured default routes:

- /graphql - GraphQL server endpoint used for processing queries and mutations
- /subscriptions - GraphQL server endpoint used for processing subscriptions
- /sdl - Convenience endpoint that returns current schema in Schema Definition Language format
- /playground - Prisma Labs GraphQL Playground IDE endpoint

### Technologies used
- [Gradle](https://github.com/gradle/gradle)
- [Kotlin](https://github.com/JetBrains/kotlin)
- [MockK](https://github.com/mockk/mockk)
- [Kotest](https://github.com/kotest/kotest)
- [GraphQL](https://github.com/ExpediaGroup/graphql-kotlin)
- [Spring WebFlux](https://spring.io/reactive)
- [Spring Data R2DBC](https://spring.io/projects/spring-data-r2dbc)
- [PostgreSQL](https://www.postgresql.org/)
