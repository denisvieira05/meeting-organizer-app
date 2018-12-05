package org.js.denisvieira.meeting_organizer.domain.entity

class UserSession(val id: Int, val accessToken: String, val tokenType: String,
                  val nickname: String, val name: String, val email: String, val company: String) {

    val accessTokenAsHeader: String
        get() = "Bearer $accessToken"
}