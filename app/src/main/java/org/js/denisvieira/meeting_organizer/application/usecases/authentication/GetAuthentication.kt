package org.js.denisvieira.meeting_organizer.application.usecases.authentication

import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum
import org.js.denisvieira.meeting_organizer.services.RemoteErrorResponse
import org.js.denisvieira.meeting_organizer.services.authentication.AuthRemoteDataSource
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthRequest
import org.js.denisvieira.meeting_organizer.application.UseCase

class GetAuth(authRemoteDataSource: AuthRemoteDataSource) {

    private val mAuthRemoteDataSource: AuthRemoteDataSource = checkNotNull(authRemoteDataSource)

    fun authorize(request: AuthRequest, callback: UseCase.UseCaseAuthCallback) {

        mAuthRemoteDataSource.authorize(request, object : AuthRemoteDataSource.AuthCallback {
            override fun onAuthorized() {
                callback.onSuccess()
            }

            override fun onFailed(remoteErrorResponse: RemoteErrorResponse) {
                callback.onError(AuthRemoteErrorCodeEnum.getEnum(remoteErrorResponse.code)!!)
            }

        })
    }

}
