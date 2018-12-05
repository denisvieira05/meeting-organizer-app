package org.js.denisvieira.meeting_organizer.application.modules.authentication

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import org.js.denisvieira.meeting_organizer.R
import org.js.denisvieira.meeting_organizer.application.modules.selectguideline.SelectGuidelineActivity
import org.js.denisvieira.meeting_organizer.databinding.SigninFragBinding
import org.js.denisvieira.meeting_organizer.domain.constants.authentication.AuthRemoteErrorCodeEnum
import java.util.*
import java.util.regex.Pattern

class SignInFragment : Fragment(), AuthenticationContract.View {

    private lateinit var mSigninFragBinding: SigninFragBinding
    private var mPresenter: AuthenticationContract.Presenter? = null
    private var authRemoteErrorCodeEnumStringHashMap: HashMap<AuthRemoteErrorCodeEnum, String>? = null

    private var mEmailEditText: EditText? = null
    private var mPasswordEditText: EditText? = null
    private var mEmailInputLayout: TextInputLayout? = null
    private var mPasswordInputLayout: TextInputLayout? = null

    companion object {

        fun newInstance(): SignInFragment {
            return SignInFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mSigninFragBinding = DataBindingUtil.inflate(inflater, R.layout.signin_frag, container, false)

        mEmailInputLayout = mSigninFragBinding.emailInputLayout
        mPasswordInputLayout = mSigninFragBinding.passwordInputLayout
        mEmailEditText = mEmailInputLayout!!.editText
        mPasswordEditText = mPasswordInputLayout!!.editText

        mSigninFragBinding.loginFragOnLoginLoadingProgressBar.indeterminateDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY)

        setupAuthRemoteErrorCodeEnumStringHashMap()

        mSigninFragBinding.loginFragMainFormButtonLinearLayout.setOnClickListener {
            onSubmitForm(it)
        }

        return mSigninFragBinding.root
    }

    override fun onSubmitForm(view: View) {
        if (isFieldsValidated()) {
            validationSucceeded()
        }
    }

    override fun onFormValidationSucceeded() {
        val intent = Intent(context, SelectGuidelineActivity::class.java)
        startActivity(intent)
    }

    override fun onFormValidationFailed(authRemoteErrorCodeEnum: AuthRemoteErrorCodeEnum) {
        mSigninFragBinding.loginFragErrorAuthTextView.visibility = View.GONE
        val errorMessage = authRemoteErrorCodeEnumStringHashMap!![authRemoteErrorCodeEnum]

        mSigninFragBinding.loginFragErrorAuthTextView.visibility = View.VISIBLE
        mSigninFragBinding.loginFragErrorAuthTextView.text = errorMessage
    }

    override fun showRemoteRequestLoader() {
        mSigninFragBinding.loginFragJoinTextView.visibility = View.GONE
        mSigninFragBinding.loginFragOnLoginLoadingProgressBar.visibility = View.VISIBLE
    }

    override fun hideRemoteRequestLoader() {
        mSigninFragBinding.loginFragJoinTextView.visibility = View.VISIBLE
        mSigninFragBinding.loginFragOnLoginLoadingProgressBar.visibility = View.GONE
    }

    override fun setPresenter(presenter: AuthenticationContract.Presenter) {
        mPresenter = presenter
    }

    private fun isFieldsValidated(): Boolean {

        val emailText = mSigninFragBinding.emailEditText.text.toString()
        val passwordText = mSigninFragBinding.passwordEditText.text.toString()
        val isInvalidEmail = !isEmailValid(emailText)

        when {
            emailText.isEmpty() -> {
                mEmailInputLayout!!.isErrorEnabled = true
                mEmailInputLayout!!.error          = getString(R.string.authentication_errors_not_empty)
            }
            isInvalidEmail -> {
                mEmailInputLayout!!.isErrorEnabled = true
                mEmailInputLayout!!.error          = getString(R.string.authentication_errors_email)
            }
            else -> mEmailInputLayout!!.isErrorEnabled = false
        }

        if (passwordText.isEmpty()) {
            mPasswordInputLayout!!.isErrorEnabled = true
            mPasswordInputLayout!!.error          = getString(R.string.authentication_errors_not_empty)
        } else {
            mPasswordInputLayout!!.isErrorEnabled = false
        }
        return mSigninFragBinding.loginFragErrorAuthTextView.text == ""
    }

    fun validationSucceeded() {
        val email = mSigninFragBinding.emailEditText.text.toString().trim({ it <= ' ' })
        val password = mSigninFragBinding.passwordEditText.text.toString().trim({ it <= ' ' })
        mPresenter?.signIn(email, password)
    }

    private fun setupAuthRemoteErrorCodeEnumStringHashMap() {
        authRemoteErrorCodeEnumStringHashMap = HashMap()
        authRemoteErrorCodeEnumStringHashMap!![AuthRemoteErrorCodeEnum.INVALID] = getString(R.string.authentication_errors_invalid_grant)
        authRemoteErrorCodeEnumStringHashMap!![AuthRemoteErrorCodeEnum.UNAUTHORIZED] = getString(R.string.authentication_errors_invalid_grant)
        authRemoteErrorCodeEnumStringHashMap!![AuthRemoteErrorCodeEnum.SERVER_UNAVAILABLE] = getString(R.string.authentication_errors_no_network_connection)
    }

    private fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}