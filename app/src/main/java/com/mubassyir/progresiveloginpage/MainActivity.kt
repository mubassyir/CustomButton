package com.mubassyir.progresiveloginpage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {



    companion object{
        private const val DUMMY_EMAIL = "amubassyir@gmail.com"
        private const val DUMMY_PASSWORD = "123"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMyButtonEnabled()

        checkStateStatus()

        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = setMyButtonEnabled() })

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = setMyButtonEnabled() })

        btn_login.setOnClickListener (this)

    }
    override fun onClick(v: View?) {
        val mEmail = email.text.toString().trim()
        val mPassword = password.text.toString().trim()

        if (!isValidEmail(mEmail)){
            email.error = "Enter a valid email"
            email.requestFocus()
            return
        }

        if(mEmail.equals(DUMMY_EMAIL) && mPassword.equals(DUMMY_PASSWORD)){
            startActivity(Intent(this,HomePageActivity::class.java))
            val loginStateModel = LoginStateModel()
            val loginStatePreference = LoginStatePreference(this)

            loginStateModel.isLogin = true
            loginStatePreference.setState(loginStateModel)
            finish()
        } else {
            tv_alert.text = "Password and email not match"
            return
        }
    }

    private fun isValidEmail(email:CharSequence): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun checkStateStatus() {
        val loginStatePreference = LoginStatePreference(this)
        if(loginStatePreference.getState().isLogin){
            startActivity(Intent(this,HomePageActivity::class.java))
        }
    }

    private fun setMyButtonEnabled() {
        val mEmail = email.text.toString().trim()
        val mPassword = password.text.toString().trim()

        btn_login.isEnabled = mEmail.isNotEmpty() && mPassword.isNotEmpty()
    }
}
