package org.hyperskill.blackboard

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.hyperskill.blackboard.plugins.*
import org.hyperskill.blackboard.routes.*
import org.hyperskill.blackboard.routes.teacher.teacherRoutes
import org.hyperskill.blackboard.routes.userLogin.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureMonitoring()
    configureSerialization()
    println("Dev mode on " + this.environment.developmentMode)
   // configureSecurity()

    logInRoutes()
    teacherRoutes()

}
