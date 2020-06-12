package com.mubassyir.progresiveloginpage

import android.content.Context

class LoginStatePreference(context : Context) {
    companion object{
        private const val PREFERENCE_NAME = "preference_name"
        private const val LOGIN_STATE = "login_state"
    }

    private val loginPreference = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun setState(value: LoginStateModel){
        val editor = loginPreference.edit()
        editor.putBoolean(LOGIN_STATE,value.isLogin)
        editor.apply()
    }
    fun getState():LoginStateModel{
        val loginStateModel = LoginStateModel()
        loginStateModel.isLogin = loginPreference.getBoolean(LOGIN_STATE,false)
        return loginStateModel
    }
}