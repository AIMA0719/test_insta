package com.example.test_insta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.example.test_insta.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    var auth : FirebaseAuth? = null
    var googleSignInClient : GoogleSignInClient? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.emailLogin.setOnClickListener {
            signInAndSignup()
        }
    }
    fun signInAndSignup(){
        auth?.createUserWithEmailAndPassword(binding.emailEdittext.text.toString(),binding.passwordEdittext.text.toString())
            ?.addOnCompleteListener {
                task ->
                    if(task.isSuccessful){
                        moveMainPage(task.result?.user)
                    } else if (task.exception?.message.isNullOrEmpty()){
                        Toast.makeText(this,task.exception?.message,Toast.LENGTH_SHORT).show()
                    }else{
                        signinEmail()
                    }
            }
    }
    fun signinEmail(){
        auth?.createUserWithEmailAndPassword(binding.emailEdittext.text.toString(),binding.passwordEdittext.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful){
                    moveMainPage(task.result?.user)
                } else{
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun moveMainPage(user:FirebaseUser?){
        if(user != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
