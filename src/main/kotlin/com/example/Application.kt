package com.example

import com.example.database.DatabaseFactory
import com.example.plugins.*
import com.example.services.UserService
import com.example.services.UserServiceImpl
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    // Call database
    DatabaseFactory.init(config = environment.config)

    // Initialize userService
    val userService:UserService by lazy {
        UserServiceImpl()
    }


    configureSerialization()
    configureRouting(
        userService = userService
    )
}
