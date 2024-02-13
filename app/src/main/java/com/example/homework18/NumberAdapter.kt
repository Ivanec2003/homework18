package com.example.homework18

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework18.list.TodoListDeletedTaskFragment
import com.example.homework18.list.TodoListDoneTaskFragment
import com.example.homework18.list.TodoListProgressFragment
import com.example.homework18.profile.ProfileFragment

class NumberAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0->ProfileFragment()
            1->TodoListProgressFragment()
            2->TodoListDoneTaskFragment()
            3->TodoListDeletedTaskFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}