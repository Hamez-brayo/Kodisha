package com.example.kodisha

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }


    private val frags = arrayListOf(
        //this one stores the fragments you want  to be output in the viewpager in an array list
        home(),
        explore(),
        UserProfile(),

    )

    override fun createFragment(position: Int): Fragment {
        return frags.get(index = position)
    }
}
