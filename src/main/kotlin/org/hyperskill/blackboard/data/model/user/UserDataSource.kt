package org.hyperskill.blackboard.data.model.user

interface UserDataSource {
    suspend fun getUserByUsername(username: String) : LogInRequest?
}