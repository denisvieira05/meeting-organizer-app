package org.js.denisvieira.meeting_organizer.application.modules.authentication

import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum
import org.js.denisvieira.powermarvelapp.application.BasePresenter
import org.js.denisvieira.powermarvelapp.application.BaseView

interface AuthenticationContract {

    interface View : BaseView<Presenter> {
        fun onSubmitForm(view: android.view.View)
        fun onFormValidationSucceeded()
        fun onFormValidationFailed(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum)
    }

    interface Presenter : BasePresenter {
        fun signIn(email: String, password: String)
        fun signUp(name: String, email: String, password: String)
        fun rememberPassword(email: String)
    }
}
