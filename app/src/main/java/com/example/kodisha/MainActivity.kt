package com.example.kodisha

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.kodisha.databinding.ActivityLoginBinding
import com.example.kodisha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var binding: ActivityMainBinding


    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        handler = Handler()
        handler.postDelayed(
            {
                val intent = Intent(this, Login_activity::class.java)
                startActivity(intent)
                finish()

            }, 1500
        )
    }

}