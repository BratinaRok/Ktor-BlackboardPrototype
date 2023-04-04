package org.hyperskill.blackboard.routes.student

import io.ktor.server.application.*
import io.ktor.server.routing.*


private const val BASE_URL = "http://10.0.2.2::8080"
    fun Application.studentRoutes() {
        routing {
           // authenticate {
            getStudentGrades()
           // }
        }
    }