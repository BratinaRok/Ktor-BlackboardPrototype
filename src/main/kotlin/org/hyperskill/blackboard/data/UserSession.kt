package org.hyperskill.blackboard.data

import kotlinx.serialization.Serializable


data class UserSession(val user: String, val token: String) {

}
