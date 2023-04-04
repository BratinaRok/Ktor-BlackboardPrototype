package org.hyperskill.blackboard.data.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserGrades (val subject: String, val grade: Int) {
}