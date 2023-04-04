package org.hyperskill.blackboard.plugins

import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.server.application.*
import io.ktor.server.sessions.*
import org.hyperskill.blackboard.data.UserSession
fun Application.configureSession() {
    install(Sessions) {
//        header<UserSession>("SESSION", SessionStorageMemory())
//    }
        cookie<UserSession>("SESSION", SessionStorageMemory()) {
            cookie.path = "/"
            cookie.extensions["SameSite"] = "lax"
            cookie.maxAgeInSeconds = 3600 * 24 * 365 // 1 year
            cookie.httpOnly = false

        }
    }
}
