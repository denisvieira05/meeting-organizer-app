package org.js.denisvieira.meeting_organizer.application.modules.authentication

import org.js.denisvieira.meeting_organizer.application.UseCase
import org.js.denisvieira.meeting_organizer.application.usecases.authentication.GetAuth
import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum
import org.js.denisvieira.meeting_organizer.services.authentication.dto.AuthRequest

class AuthenticationPresenter(authenticationView: AuthenticationContract.View,
                              getAuth: GetAuth) : AuthenticationContract.Presenter {

    private val mAuthenticationView: AuthenticationContract.View = checkNotNull(authenticationView)
    private val mGetAuth: GetAuth = checkNotNull(getAuth)

    init {
        mAuthenticationView.setPresenter(this)
    }

    override fun signIn(email: String, password: String) {

        val request = AuthRequest(email, password)
        mAuthenticationView.showRemoteRequestLoader()

        mGetAuth.authorize(request, object : UseCase.UseCaseAuthCallback {
            override fun onSuccess() {
                mAuthenticationView.hideRemoteRequestLoader()
                mAuthenticationView.onFormValidationSucceeded()
            }

            override fun onError(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
                mAuthenticationView.hideRemoteRequestLoader()
                mAuthenticationView.onFormValidationFailed(authRemoteErrorCodeEnum)
            }

        })

    }

    override fun signUp(name: String, email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rememberPassword(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
