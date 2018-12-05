package org.js.denisvieira.meeting_organizer.services.authentication.dto

class AuthResponse(val accessToken: String, val tokenType: String, created_at: String, val person: UserResponse) {

    val accessTokenAsHeader: String
        get() = "Bearer $accessToken"

    fun getAccess_token(): String {
        return accessToken
    }

    fun getToken_type(): String {
        return tokenType
    }
}
