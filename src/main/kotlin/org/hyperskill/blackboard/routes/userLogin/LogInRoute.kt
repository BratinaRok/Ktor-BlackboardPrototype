package org.hyperskill.blackboard.routes.userLogin

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.hyperskill.blackboard.data.model.user.LogInRequest

import io.ktor.http.cio.*
import io.ktor.util.reflect.*
import org.hyperskill.blackboard.data.model.user.User
import org.hyperskill.blackboard.data.model.user.Users

fun Route.logInRoute() {
    post("/login") {
        val loginRequest = call.receive<LogInRequest>()

        val user = Users.userData[loginRequest.username]
        if (user?.base64sha256HashPass == loginRequest.pass) {
            val token = generateToken(user) // Generate a token for the authenticated user
            val role = user.getRole()
            call.respond(mapOf("token" to token, "role" to role)) // Respond with the token and student or teacher role
        } else {
            call.respond(HttpStatusCode.Unauthorized) // Invalid credentials, respond with an unauthorized status code
        }
    }
}

fun checkUserRole(username: String): String {
    return (
            when (username) {
                "user1", "user2" -> "TEACHER"
                "user3", "user4" -> "STUDENT"
                else -> {
                    "no user role"
                }
            })
}


fun generateToken(user: User): String {
    val jwtAlg = Algorithm.HMAC256("testSecret")
    return JWT.create()
        .withIssuer("blackBoardApp")
        .withSubject(user.getUsername())
        .withClaim("ROLE", user.getRole())
        .sign(jwtAlg)
}

