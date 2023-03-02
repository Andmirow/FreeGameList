package com.example.freegamelist.presentation

import androidx.fragment.app.Fragment

interface FragmentControl {
    fun closeFragment()
    fun openNewFragment(fragment : Fragment)
}