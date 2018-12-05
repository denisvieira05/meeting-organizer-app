package org.js.denisvieira.meeting_organizer.application.modules.authentication

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.js.denisvieira.meeting_organizer.R
import org.js.denisvieira.meeting_organizer.databinding.SignupFragBinding
import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum
import java.util.*
import java.util.regex.Pattern


class SignUpFragment : Fragment(), AuthenticationContract.View {


    private lateinit var mSignupFragBinding: SignupFragBinding
    private var mPresenter: AuthenticationContract.Presenter? = null

    companion object {

        fun newInstance(): SignUpFragment {
            return SignUpFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mSignupFragBinding = DataBindingUtil.inflate(inflater, R.layout.signup_frag, container, false);

        mSignupFragBinding.loginFragOnLoginLoadingProgressBar.indeterminateDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY)

        return mSignupFragBinding.root
    }

    override fun onSubmitForm(view: View) {
        if (isFieldsValidated()) {
            validationSucceeded()
        }
    }

    override fun onFormValidationSucceeded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFormValidationFailed(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRemoteRequestLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRemoteRequestLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: AuthenticationContract.Presenter) {
        mPresenter = presenter
    }

    private fun isFieldsValidated(): Boolean {

        val emailText = mSignupFragBinding.loginFragEmailEditText.text.toString()
        val passwordText = mSignupFragBinding.loginFragPasswordEditText.text.toString()
        val isInvalidEmail = !isEmailValid(emailText)

        Optional.ofNullable<Context>(context).ifPresent {
            if (emailText.isEmpty()) {
                mSignupFragBinding.loginFragErrorAuthTextView.text = getString(R.string.authentication_errors_not_empty)
            } else if (isInvalidEmail) {
                mSignupFragBinding.loginFragErrorAuthTextView.text = getString(R.string.authentication_errors_email)
            } else {
                mSignupFragBinding.loginFragErrorAuthTextView.text = ""
            }

            if (passwordText.isEmpty()) {
                mSignupFragBinding.loginFragErrorAuthTextView.text = getString(R.string.authentication_errors_not_empty)
            } else {
                mSignupFragBinding.loginFragErrorAuthTextView.text = ""
            }

        }

        return mSignupFragBinding.loginFragErrorAuthTextView.text == ""
    }

    fun validationSucceeded() {
        val email = mSignupFragBinding.loginFragEmailEditText.text.toString().trim({ it <= ' ' })
        val password = mSignupFragBinding.loginFragPasswordEditText.text.toString().trim({ it <= ' ' })
        mPresenter?.signIn(email, password)
    }

    private fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}