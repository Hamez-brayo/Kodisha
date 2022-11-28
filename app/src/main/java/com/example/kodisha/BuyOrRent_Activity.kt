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



//        findViewById<ImageView>(R.id.BackgroundBlue).setOnClickListener{
//            startActivity(Intent(this@BuyOrRent_Activity,RentActivity::class.java))
//        }
        listeners()
    }

    private fun listeners() {
       binding.BackgroundWhite.setOnClickListener{
            startActivity(Intent(this@BuyOrRent_Activity,RentActivity::class.java))

        }
        binding.BackgroundBlue.setOnClickListener{
            startActivity(Intent(this@BuyOrRent_Activity,BuyActivity::class.java ))
        }
//        findViewById<ImageView>(R.id.BackgroundBlue).setOnClickListener{
//            startActivity(Intent(this@BuyOrRent_Activity,BuyActivity::class.java))
//
//        }

    }
}