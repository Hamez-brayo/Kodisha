package com.example.kodisha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.kodisha.databinding.ActivityBuyOrRentBinding
import com.example.kodisha.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class BuyOrRent_Activity : AppCompatActivity() {
    lateinit var binding: ActivityBuyOrRentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBuyOrRentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        listeners()
    }

    private fun listeners() {
       binding.BackgroundWhite.setOnClickListener{
            startActivity(Intent(this@BuyOrRent_Activity,RentActivity::class.java))
           finish()

        }
        binding.BackgroundBlue.setOnClickListener{
            startActivity(Intent(this@BuyOrRent_Activity,LandingActivity::class.java ))
            finish()
        }

    }
}