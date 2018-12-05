package org.js.denisvieira.meeting_organizer.domain.converters

import org.js.denisvieira.meeting_organizer.domain.entity.UserSession
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthResponse
import org.js.denisvieira.meeting_organizer.services.session.dto.UserSessionEntry


object UserSessionConverter {

    fun convertFromResponse(authResponse: AuthResponse?, deviceId: String): UserSession? {
        if (authResponse == null) return null

        val userResponse = authResponse.person

        val id = userResponse.id
        val accessToken = authResponse.accessToken
        val tokenType = authResponse.tokenType
        val nickname = userResponse.nickName
        val name = userResponse.name
        val email = userResponse.email
        val company = userResponse.company

        return UserSession(id, accessToken, tokenType, nickname, name, email, company)
    }

    fun convertFromEntry(entry: UserSessionEntry?): UserSession? {
        return if (entry == null) null else UserSession(
                entry.id,
                entry.token!!,
                entry.token_type!!,
                entry.nickname!!,
                entry.name!!,
                entry.email!!,
                entry.company!!
        )

    }

    fun convertFromEntity(userSession: UserSession?): UserSessionEntry? {
        if (userSession == null) return null

        val entry        = UserSessionEntry()

        entry.token      = userSession.accessToken
        entry.token_type = userSession.tokenType
        entry.id         = userSession.id
        entry.name       = userSession.name
        entry.email      = userSession.email
        entry.company    = userSession.company
        entry.nickname   = userSession.nickname

        return entry
    }
}