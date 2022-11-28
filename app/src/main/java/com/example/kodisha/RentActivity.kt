package com.example.kodisha

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.kodisha.databinding.ActivityRentBinding
import java.lang.NullPointerException
import java.sql.Types.NULL

class RentActivity : AppCompatActivity() {

    lateinit var binding: ActivityRentBinding
    lateinit var ImageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AddBox.setOnClickListener {
            selectImage()


        }


    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action= Intent.ACTION_GET_CONTENT




        startActivityForResult(intent, 100)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( requestCode==100&& resultCode== RESULT_OK && data != null && data.data != null){
            ImageUri= data.data!!
            binding.AddBox.setImageURI(ImageUri)

        }
    }

}





