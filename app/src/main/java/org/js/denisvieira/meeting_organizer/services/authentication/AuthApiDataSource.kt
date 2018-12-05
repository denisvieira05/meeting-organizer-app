package org.js.denisvieira.meeting_organizer.services.authentication

import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthRequest
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface AuthApiDataSource {

    @POST("authenticate")
    fun authorize(@Body request: AuthRequest): Observable<AuthResponse>

}