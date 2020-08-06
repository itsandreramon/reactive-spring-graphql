# Reactive Spring GraphQL
An example project showcasing a simple service which serves data about famous books.

### How to run the sample
1. Build a container image using Spring Boot's Buildpack support
```
$ ./gradlew bootBuildImage --imageName=demo/spring-graphql
```

2. Make sure the corresponding demo/spring-graphql image has been built
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
5. Access PostgreSQL to make changes according to your needs
```
$ docker exec -it database psql -U postgres
```

### Example GraphQL query
```
subscription {
    allBooks {
        name
        pageCount
    }
}
```

#### Default Routes
Your newly created GraphQL server starts up with following preconfigured default routes:

- /graphql - GraphQL server endpoint used for processing queries and mutations
- /subscriptions - GraphQL server endpoint used for processing subscriptions
- /sdl - Convenience endpoint that returns current schema in Schema Definition Language format
- /playground - Prisma Labs GraphQL Playground IDE endpoint

### Technologies used
- [Gradle](https://github.com/gradle/gradle)
- [Kotlin](https://github.com/JetBrains/kotlin)
- [GraphQL Kotlin by Expedia](https://github.com/ExpediaGroup/graphql-kotlin)
- [Spring WebFlux](https://spring.io/reactive)
- [Spring Data R2DBC](https://spring.io/projects/spring-data-r2dbc)
- [PostgreSQL](https://www.postgresql.org/)
