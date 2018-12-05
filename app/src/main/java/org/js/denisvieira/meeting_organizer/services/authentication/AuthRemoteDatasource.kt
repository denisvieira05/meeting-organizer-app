package org.js.denisvieira.meeting_organizer.services.authentication

import org.js.denisvieira.meeting_organizer.services.RemoteErrorResponse
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthRequest

interface AuthRemoteDataSource {

    interface AuthCallback {
        fun onAuthorized()
        fun onFailed(remoteErrorResponse: RemoteErrorResponse)
    }

    fun authorize(request: AuthRequest, callback: AuthCallback)
}
