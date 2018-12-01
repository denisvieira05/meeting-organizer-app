package org.js.denisvieira.meeting_organizer.application.login

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.js.denisvieira.meeting_organizer.R
import org.js.denisvieira.meeting_organizer.databinding.LoginActBinding

class LoginActivity : AppCompatActivity(), LoginContract.View  {


    private lateinit var mLoginActivityBinding: LoginActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLoginActivityBinding = DataBindingUtil.setContentView(this,
                R.layout.login_act)
    }

    override fun login(view: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToSelectConstructionSite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
//
//    override fun showLoginErrors(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun showInitTutorial() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRemoteRequestLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRemoteRequestLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
