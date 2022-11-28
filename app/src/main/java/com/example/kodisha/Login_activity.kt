package com.example.kodisha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.kodisha.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login_activity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
       login()
//        binding.LoginBTN.setOnClickListener{
//            startActivity(Intent(this,BuyOrRent_Activity::class.java))
//        }
    }

    private fun login() {
        binding.LoginBTN.setOnClickListener {
            if (TextUtils.isEmpty(R.id.et_email.toString())) {
                Toast.makeText(
                    this,
                    "Empty Email!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (TextUtils.isEmpty(R.id.et_password.toString())) {
                Toast.makeText(
                    this,
                    "Empty Password!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val Email = binding.etEmail.text.toString()
            val Pass = binding.etPassword.text.toString()
            auth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener {
                if (it.isSuccessful) {

                    startActivity(Intent(this@Login_activity, BuyOrRent_Activity::class.java))

                    //Toast.makeText(this@Login_activity,"Correct Credentials", Toast.LENGTH_LONG).show()

//                    finish()

                } else {
                    Toast.makeText(this@Login_activity, "Invalid Credentials", Toast.LENGTH_LONG)
                        .show()


                }
            }
        }
        binding.DontHaveACc.setOnClickListener {
            startActivity(Intent(this@Login_activity, Register_activity::class.java))
        }
    }
}