package org.hyperskill.blackboard.routes.teacher

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://10.0.2.2::8080"
    fun Application.teacherRoutes() {
        routing {
           // authenticate {
                listStudentsRoute()
           // }
        }
    }