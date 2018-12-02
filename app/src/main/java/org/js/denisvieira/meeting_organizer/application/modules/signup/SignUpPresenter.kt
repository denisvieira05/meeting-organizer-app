package org.js.denisvieira.meeting_organizer.application.login

import android.content.Context

class SignUpPresenter(signinView: SigninContract.View,
//                     getAuth: GetAuth,
                      context: Context) : SigninContract.Presenter {

    private val mSigninView: SigninContract.View
    private val context: Context
//    private val mGetAuth: GetAuth

    init {
        this.mSigninView = checkNotNull(signinView)
//        this.mGetAuth = checkNotNull(getAuth)
        this.context = checkNotNull(context)

        mSigninView.setPresenter(this)
    }


    override fun login(email: String, password: String, deviceId: String) {

//        val request = AuthRequest(email, password, deviceId)
//        mSigninView.showRemoteRequestLoader()
//
//        mGetAuth.authorize(request, object : UseCase.UseCaseAuthCallback() {
//            fun onSuccess() {
//                mSigninView.hideRemoteRequestLoader()
//                mSigninView.goToSelectConstructionSite()
//            }
//
//            fun onError(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
//                mSigninView.hideRemoteRequestLoader()
//                mSigninView.showLoginErrors(authRemoteErrorCodeEnum)
//            }
//
//        })

    }
}
