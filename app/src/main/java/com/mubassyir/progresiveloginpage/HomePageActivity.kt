package com.mubassyir.progresiveloginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        btn_logout.setOnClickListener{
            val loginStatePreference = LoginStatePreference(this)
            val loginStateModel = LoginStateModel()

            startActivity(Intent(this,MainActivity::class.java))
            loginStateModel.isLogin = false
            loginStatePreference.setState(loginStateModel)

            finish()
        }
    }
}
