package com.example.guri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginLoginBtnClicked(view: View){

    }

    fun loginCreateUserBtnClicked(view: View){
        val createUserIntent = Intent(this,CreateUserActivity::class.java)
        startActivity(createUserIntent)
    }
}
