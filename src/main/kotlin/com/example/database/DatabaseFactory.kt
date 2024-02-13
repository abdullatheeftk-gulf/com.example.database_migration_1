package com.example.database

import io.ktor.server.config.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init(config:ApplicationConfig){

        // Loading data from application.conf file
        val postgresDriverClassName = config.property("postgres.driverClassName").getString()
        val postgresUrl = config.property("postgres.jdbcURL").getString()
        val postgresUser = config.property("postgres.user").getString()
        val postgresPassword = config.property("postgres.password").getString()

        val database = Database.connect(
            url = postgresUrl,
            driver = postgresDriverClassName,
            user = postgresUser,
            password = postgresPassword
        )

        transaction(database) {
            // ToDo
        }



    }
}