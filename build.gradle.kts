import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(from = "$rootDir/ktlint.gradle.kts")

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
    id("com.palantir.graal") version "0.7.1"
}

group = "com.andreramon"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

if (hasProperty("buildScan")) {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

repositories {
    mavenCentral()
    jcenter()

    maven(url = "https://repo.spring.io/milestone")
    maven(url = "https://repo.spring.io/snapshot")
}

graal {
    javaVersion("11")
    graalVersion("20.1.0")
    option("--no-fallback")
    mainClass("com.andreramon.demo.App")
    outputName("native-app")
}

detekt {
    buildUponDefaultConfig = true
    ignoreFailures = true
    failFast = false
    parallel = true
    debug = true
}

dependencies {

    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.experimental:spring-graalvm-native:0.7.1")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Reactor
    // implementation("io.projectreactor:reactor-tools")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    // Postgres
    runtimeOnly("io.r2dbc:r2dbc-postgresql")
    runtimeOnly("org.postgresql:postgresql")

    // GraphQL
    implementation("com.expediagroup:graphql-kotlin-spring-server:3.6.1")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("io.projectreactor:reactor-test")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    withType<Detekt> {
        this.jvmTarget = "1.8"
    }

    withType<Test> {
        useJUnitPlatform()
    }
}