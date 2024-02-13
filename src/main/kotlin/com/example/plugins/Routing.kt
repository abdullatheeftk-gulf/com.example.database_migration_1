package com.example.plugins

import com.example.models.User
import com.example.services.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    userService: UserService
) {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/addAUser") {
           try{
               val user = call.receive<User>()
               userService.addUser(user = user)
               call.respond("added user")

           }catch (e:Exception){
               call.respond(status = HttpStatusCode.BadRequest, message = e.message ?:"There have some problem")
           }
        }

        get("/getAllUsers"){
            try{
                val users = userService.getAllUser()
                call.respond(users)

            }catch (e:Exception){
                call.respond(status = HttpStatusCode.BadRequest, message = e.message ?:"There have some problem")
            }
        }
    }
}
