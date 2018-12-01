package org.js.denisvieira.meeting_organizer.application.login

import android.content.Context

class LoginPresenter(loginView: LoginContract.View,
//                     getAuth: GetAuth,
                     context: Context) : LoginContract.Presenter {

    private val mLoginView: LoginContract.View
    private val context: Context
//    private val mGetAuth: GetAuth

    init {
        this.mLoginView = checkNotNull(loginView)
//        this.mGetAuth = checkNotNull(getAuth)
        this.context = checkNotNull(context)

        mLoginView.setPresenter(this)
    }


    override fun login(email: String, password: String, deviceId: String) {

//        val request = AuthRequest(email, password, deviceId)
//        mLoginView.showRemoteRequestLoader()
//
//        mGetAuth.authorize(request, object : UseCase.UseCaseAuthCallback() {
//            fun onSuccess() {
//                mLoginView.hideRemoteRequestLoader()
//                mLoginView.goToSelectConstructionSite()
//            }
//
//            fun onError(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
//                mLoginView.hideRemoteRequestLoader()
//                mLoginView.showLoginErrors(authRemoteErrorCodeEnum)
//            }
//
//        })

    }
}
