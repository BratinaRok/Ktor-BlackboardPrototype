package org.hyperskill.blackboard.routes.student

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.hyperskill.blackboard.data.model.user.UserGrades

fun Route.getStudentGrades() {
    authenticate("auth-jwt") {
        get("/student/{username}/grade") {
//            val authHeader = call.request.headers["Authorization"]
//            val token = authHeader?.removePrefix("token ")
            val username = call.parameters["username"]
            if (username == "user2") {
                val grades = listOf(
                    UserGrades("math", 90),
                    UserGrades("History", 50))
                call.respond(
                    HttpStatusCode.OK,
                    Json.encodeToString(grades)
                )
            } else
                call.respond(HttpStatusCode.Unauthorized)
            }
        }
    }