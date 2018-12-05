package org.js.denisvieira.meeting_organizer.application

import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum

interface UseCase {

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
        fun onError(errorDescription: String)
    }

    interface VoidUseCaseCallback {
        fun onSuccess()
        fun onError(errorDescription: String)
    }

    interface LoadUseCaseCallback<R> {
        fun onLoaded(response: R)
        fun onEmptyData()
        fun onFailed(errorDescription: String)
    }

    interface UseCaseAuthCallback {
        fun onSuccess()
        fun onError(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum)
    }

}
