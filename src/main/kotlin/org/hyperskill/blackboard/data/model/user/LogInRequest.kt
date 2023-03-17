package org.hyperskill.blackboard.data.model.user

import kotlinx.serialization.Serializable

@Serializable
data class LogInRequest(
    val username: String,
    val password: String
)
