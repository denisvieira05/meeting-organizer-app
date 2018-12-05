package org.js.denisvieira.meeting_organizer.application.modules.authentication

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import org.js.denisvieira.meeting_organizer.R
import org.js.denisvieira.meeting_organizer.databinding.AuthenticationActBinding
import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthenticationScreenStateEnum

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var mAuthenticationActBinding: AuthenticationActBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuthenticationActBinding = DataBindingUtil.setContentView(this,
                R.layout.authentication_act)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.auth_content_frame, SignInFragment.newInstance(), AuthenticationScreenStateEnum.SIGN_IN.value)
                    .commit()
        }

        mAuthenticationActBinding.authenticationScreenStateEnum = AuthenticationScreenStateEnum.SIGN_IN
    }

    fun onPressSignUpLink(view: View) {
        val signUpFragment = SignUpFragment.newInstance()
        updateFragmentFormToShow(signUpFragment, AuthenticationScreenStateEnum.SIGN_UP)
    }

    fun onPressRememberPasswordLink(view: View) {
        val rememberPasswordFragment = RememberPasswordFragment.newInstance()
        updateFragmentFormToShow(rememberPasswordFragment, AuthenticationScreenStateEnum.REMEMBER_PASSWORD)
    }

    fun onPressBackToLoginLink(view: View) {
        val signInFragment = SignInFragment.newInstance()
        updateFragmentFormToShow(signInFragment, AuthenticationScreenStateEnum.SIGN_IN)
    }

    fun updateFragmentFormToShow(fragment: Fragment, authenticationScreenStateEnum: AuthenticationScreenStateEnum) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.auth_content_frame, fragment, authenticationScreenStateEnum.value)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()

        mAuthenticationActBinding.authenticationScreenStateEnum = authenticationScreenStateEnum
    }


}
