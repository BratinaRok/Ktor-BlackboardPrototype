package org.hyperskill.blackboard.data.model.user

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.*

class User(private val username: String, plainPass: String, private val role: String) {
    companion object {
        private val messageDigest = MessageDigest.getInstance("SHA-256")
    }

    private val plainPassBytes = plainPass.toByteArray(StandardCharsets.UTF_8)
    private val sha256HashPass = messageDigest.digest(plainPassBytes)
    val base64sha256HashPass = Base64.getEncoder().encodeToString(sha256HashPass)

    fun getUsername() : String {
        return username
    }

    fun getRole() : String {
        return role
    }
}

