
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.8"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
    id("org.flywaydb.flyway") version "10.7.2"
}

buildscript {
    dependencies {
        classpath("org.postgresql:postgresql:42.7.1")
        classpath("org.flywaydb:flyway-database-postgresql:10.7.2")
    }
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Exposed orm dependencies
    implementation("org.jetbrains.exposed:exposed-core:0.47.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.47.0")

    // Postgresql dependency
    implementation("org.postgresql:postgresql:42.7.1")


}

// Add flyway configuration after adding Flyway gradle plugin

flyway{
    driver="org.postgresql.Driver"

    // Database name is migration-sample
    url = "jdbc:postgresql://localhost:5432/migration-sample"

    // Database username is postgres
    user="postgres"
    // Database password
    password="9526317685"

    cleanDisabled=false
}
