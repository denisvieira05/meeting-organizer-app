package org.js.denisvieira.meeting_organizer.application.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.js.denisvieira.meeting_organizer.R
import org.js.denisvieira.meeting_organizer.databinding.SigninActBinding

class SignInActivity : AppCompatActivity(), SigninContract.View  {


    private lateinit var mSigninActBinding: SigninActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mSigninActBinding = DataBindingUtil.setContentView(this,
                R.layout.signin_act)
    }

    override fun onPressSignUp(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToGuidelinesList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//
//    override fun showLoginErrors(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun showRemoteRequestLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRemoteRequestLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: SigninContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
