package org.js.denisvieira.meeting_organizer.application.login

import org.js.denisvieira.powermarvelapp.application.BasePresenter
import org.js.denisvieira.powermarvelapp.application.BaseView

interface SignUpContract {

    interface View : BaseView<Presenter> {
        fun onPressSignIn(view: android.view.View)
        fun goToGuidelinesList()
//        fun showLoginErrors(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum)
    }

    interface Presenter : BasePresenter {
        fun login(username: String, password: String, deviceId: String)
    }
}
