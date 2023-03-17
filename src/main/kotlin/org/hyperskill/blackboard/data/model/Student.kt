package org.hyperskill.blackboard.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val id: Int,
    val name: String,
    val lastName: String
)
