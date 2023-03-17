package org.hyperskill.blackboard.plugins

import io.ktor.server.sessions.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

//fun Application.configureSecurity() {
//    install(Authentication) {
//        bearer {
//            validate { token ->
//                if (token == "my-secret-token") {
//                    UserIdPrincipal("user123")
//                } else {
//                    null
//                }
//            }
//        }
//    }


