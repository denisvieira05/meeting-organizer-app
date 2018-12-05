package org.js.denisvieira.meeting_organizer.services.authentication

import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthRequest
import org.js.denisvieira.meeting_organizer.services.session.SessionLocalDataSource


class AuthRemoteDataSourceImpl(apiDataSource: AuthApiDataSource, sessionLocalDataSource: SessionLocalDataSource) : AuthRemoteDataSource {

    private var INSTANCE:AuthRemoteDataSourceImpl? = null
    private val mApiDataSource: AuthApiDataSource? = checkNotNull(apiDataSource)
    private val mSessionLocalDataSource: SessionLocalDataSource = checkNotNull(sessionLocalDataSource)

    companion object {

        private var INSTANCE: AuthRemoteDataSourceImpl? = null

        fun getInstance(apiDataSource: AuthApiDataSource, sessionLocalDataSource: SessionLocalDataSource): AuthRemoteDataSource {
            if (INSTANCE == null)
                INSTANCE = AuthRemoteDataSourceImpl(apiDataSource, sessionLocalDataSource)

            return INSTANCE as AuthRemoteDataSourceImpl
        }
    }

    override fun authorize(request: AuthRequest, callback: AuthRemoteDataSource.AuthCallback) {
//        mApiDataSource.authorize(request)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ authResponse ->
//                    val userSession = UserSessionConverter.convertFromResponse(authResponse, request.getDeviceId())
//                    mSessionLocalDataSource.save(userSession)
                    callback.onAuthorized()
//                }, { throwable ->
//                    val error = throwable as RetrofitException
//                    val errorResponse = error.getErrorBodyAs(RemoteErrorResponse::class.java)
//                    callback.onFailed(errorResponse)
//                })
    }


}