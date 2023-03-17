package org.hyperskill.blackboard.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*

//fun Application.configureAuthentication() {
//    install(Authentication) {
//            bearer("auth") {
//                validate {
//                    val token = it.token
//                    if (isValidToken(token)) {
//                        UserIdPrincipal(getUsernameFromToken(token)) // Return the authenticated user
//                    } else {
//                        null // Invalid token, return null
//                    }
//                }
//            }
//        }