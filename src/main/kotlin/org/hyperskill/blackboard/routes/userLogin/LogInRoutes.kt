package org.hyperskill.blackboard.routes.userLogin

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.hyperskill.blackboard.routes.teacher.listStudentsRoute

fun Application.logInRoutes() {
    routing {
        logInRoute()
    }
}