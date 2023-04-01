package org.hyperskill.blackboard.routes.teacher

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.hyperskill.blackboard.data.model.Student

@Serializable
private val students = listOf(
    Student(0, "John", "Black"),
    Student(1, "Jane", "Doe"),
    Student(2, "Bob", "Smith"),
    Student(3, "Mary", "Jones"),
    Student(4, "Tom", "Brown"),
    Student(5, "Lily", "White")
)

fun Route.listStudentsRoute() {
    get("/teacher/student") {
        call.respond(
            HttpStatusCode.OK,
            Json.encodeToString(students)
        )
            }

    }

