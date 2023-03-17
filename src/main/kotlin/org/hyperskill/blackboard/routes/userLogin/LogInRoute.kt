package org.hyperskill.blackboard.routes.userLogin

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.hyperskill.blackboard.data.model.user.LogInRequest
import java.util.*

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import io.ktor.utils.io.core.*
import kotlin.text.toByteArray

fun Route.logInRoute() {
    post("/login") {
        val loginRequest = call.receive<LogInRequest>()

        if (isValidLogin(loginRequest.username, loginRequest.password)) {
            val token = generateToken(loginRequest.username) // Generate a token for the authenticated user
            val role = checkUserRole(loginRequest.username)
            call.respond(mapOf("token" to token, "role" to role)) // Respond with the token and student or teacher role
        } else {
            call.respond(HttpStatusCode.Unauthorized) // Invalid credentials, respond with an unauthorized status code
        }
    }
}

fun checkUserRole(username: String): String {
    return (
            when (username) {
                "user1", "user2" -> "teacher"
                "user3", "user4" -> "student"
                else -> {
                    "no user role"
                }
            })
}

fun isValidLogin(username: String, password: String): Boolean {
    val validUsernames = listOf("user1", "user2", "user3")
    val validPasswords = mapOf(
        "user1" to "password1",
        "user2" to "password2",
        "user3" to "password3",
        "user4" to "password4"
    )
    return validUsernames.contains(username) && validPasswords[username] == password
}

fun generateToken(username: String): String {
    val secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256).toString().toByteArray();
    val issuer = "my_issuer"
    val subject = username
    val expiration = Date(System.currentTimeMillis() + 86400000)
    return Jwts.builder()
        .setIssuer(issuer)
        .setSubject(subject)
        .setExpiration(expiration)
        .signWith(Keys.hmacShaKeyFor(secretKey))
        .compact()
}
