package org.js.denisvieira.meeting_organizer.application.login

import org.js.denisvieira.powermarvelapp.application.BasePresenter
import org.js.denisvieira.powermarvelapp.application.BaseView

interface LoginContract {

    interface View : BaseView<Presenter> {
        fun login(view: android.view.View)
        fun goToSelectConstructionSite()
//        fun showLoginErrors(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum)
        fun showInitTutorial()
    }

    interface Presenter : BasePresenter {
        fun login(username: String, password: String, deviceId: String)
    }
}
