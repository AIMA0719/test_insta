package com.example.test_insta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.example.test_insta.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityLoginBinding

    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
    }
    fun fuck(){
        auth?.createUserWithEmailAndPassword(binding.emailEdittext.text.toString(),binding.passwordEdittext.text.toString())
    }
}
