package com.smartapp.allinoneapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.smartapp.allinoneapp.CategoryFragment

class ViewPagerAdapter(activity: FragmentActivity)
    : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return CategoryFragment.newInstance(position)
    }
}

