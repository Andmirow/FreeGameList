package com.example.freegamelist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.freegamelist.R
import com.example.freegamelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentControl {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.popBackStack()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openNewFragment(GamesListFragment.newInstance())
    }


    override fun openNewFragment(fragment : Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun closeFragment() {
        supportFragmentManager.popBackStack()
    }

}