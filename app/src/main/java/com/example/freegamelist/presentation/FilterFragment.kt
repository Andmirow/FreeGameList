package com.example.freegamelist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment

class FilterFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            GamesListFragment().apply {
                arguments = Bundle()
            }
    }

}