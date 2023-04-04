package org.hyperskill.blackboard.plugins
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys

import io.ktor.http.*
import io.ktor.http.auth.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


const val secret = "testSecret"
const val issuer = "http://127.0.0.1:8080"
const val audience = "blackBoardApp"
const val myRealm = "Access to 'page'"
fun Application.configureAuthentication() {
    install(Authentication) {
        jwt("auth-jwt") {
            realm = myRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(secret))
//                    .withAudience(audience)
//                    .withIssuer(issuer)
                    .build()
            )

            validate { credential ->
                if (credential.payload.getClaim("ROLE").asString() != "") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }

            }
            challenge { defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid")
            }
        }

    }
}

