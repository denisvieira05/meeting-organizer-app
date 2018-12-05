package org.js.denisvieira.meeting_organizer.services.session

import org.js.denisvieira.meeting_organizer.domain.entity.UserSession

interface SessionLocalDataSource {

    fun getUserSession() : UserSession?

    fun save(userSession: UserSession): UserSession

    fun destroy()

}