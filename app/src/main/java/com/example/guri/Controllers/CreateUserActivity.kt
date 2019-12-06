package com.example.guri.Controllers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.view.View
import com.example.guri.R
import com.example.guri.Services.AuthService
import com.example.guri.Services.UserDataService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profiledefault"
    var avatarColor = "[0.5,0.5,0.5,1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View){
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        userAvatar = if (color == 0){
            "light$avatar"
        }else{
            "dark$avatar"
        }

        val resourceId = resources.getIdentifier(userAvatar,"drawable",packageName)
        createAvatarImageView.setImageResource(resourceId)
    }

    fun createUserClicked(view: View){
        val userName = createUserNameText.text.toString()
        val email = createEmailText.text.toString()
        val password = createPasswordText.text.toString()

        AuthService.registerUser(this,email,password){registerSuccess->
            if (registerSuccess){
                AuthService.loginUser(this,email,password){loginSuccess->
                    if (loginSuccess){
                        AuthService.createUser(this,userName,email,userAvatar,avatarColor){createSuccess->
                            if (createSuccess){
                                println(UserDataService.avatarName)
                                println(UserDataService.avatarColor)
                                println(UserDataService.name)
                                finish()
                            }
                        }
                    }
                }
            }

        }
    }

    fun generateColorClicked(view: View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)
        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB],1"
    }
}
