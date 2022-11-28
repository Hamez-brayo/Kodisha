package com.example.kodisha

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.StorageReference

class UserProfile : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        database=FirebaseDatabase.getInstance()
        databaseReference=database.reference.child("profile")
        val uid = auth.currentUser?.uid.toString()
        databaseReference=FirebaseDatabase.getInstance().getReference("profile")
       loadprofile()
    }

    private fun loadprofile() {
        val user=auth.currentUser
        val userreference=databaseReference.child(user?.uid!!)

        view?.findViewById<TextView>(R.id.EmailTE)?.text=user.email
        userreference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                view?.findViewById<TextView>(R.id.NameTE)?.text=snapshot.child("firstname")?.value.toString()
                view?.findViewById<TextView>(R.id.ContactTE)?.text=snapshot.child("contact")?.value.toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        view?.findViewById<ImageView>(R.id.LogoutIcon)?.setOnClickListener{
            auth.signOut()
            startActivity(Intent(activity, Login_activity::class.java))

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

}
