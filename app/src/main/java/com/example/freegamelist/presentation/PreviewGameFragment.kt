package com.example.freegamelist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment

class PreviewGameFragment : Fragment() {

    //private lateinit var binding : PreviewGameFragmentBinding
    private lateinit var fragmentControl : FragmentControl


    companion object {
        @JvmStatic
        fun newInstance() =
            PreviewGameFragment().apply {
                arguments = Bundle()
            }
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is FragmentControl) {
//            fragmentControl = context
//        } else {
//            throw RuntimeException("Activity must implement FragmentControl")
//        }
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        binding = PreviewGameFragmentBinding.inflate(inflater,container,false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.button.setOnClickListener{
//            fragmentControl.openNewFragment(GamesListFragment.newInstance())
//        }
//    }

}