package com.example.freegamelist.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.freegamelist.databinding.FragmentListGameBinding
import com.example.freegamelist.domain.GameBl
import com.example.freegamelist.domain.MyApp
import com.example.freegamelist.presentation.recycler_view_tools.GameAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GamesListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding : FragmentListGameBinding
    private lateinit var fragmentControl : FragmentControl
    private lateinit var adapter : GameAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            GamesListFragment().apply {
                arguments = Bundle()
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentControl) {
            fragmentControl = context
        } else {
            throw RuntimeException("Activity must implement FragmentControl")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewModel.fetchList((activity?.application as MyApp).gameApi)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList()
        setRecyclerView()
        setListener()
        observeLaunches()
    }


    @SuppressLint("SetTextI18n")
    private fun setListener(){
        binding.filterButton.setOnClickListener {
            fragmentControl.openNewFragment(FilterFragment.newInstance())
        }
        binding.switchSave.setOnCheckedChangeListener{ _, isChecked ->
//            MovieFilter.isPreserved = isChecked
//            viewModel.fetchList((activity?.application as FilmApp).filmApi)
        }






    }

    private fun setRecyclerView(){
        val recycler = binding.rvGameList
        recycler.layoutManager = GridLayoutManager(activity?.applicationContext, 4)
        val adapter = GameAdapter(this::openGameCard,this::deleteGame)
        recycler.adapter = adapter
        val dividerItemDecorationVERTICAL = DividerItemDecoration(recycler.context, GridLayoutManager.VERTICAL)
        val dividerItemDecorationHORIZONTAL = DividerItemDecoration(recycler.context, GridLayoutManager.HORIZONTAL)
        recycler.addItemDecoration(dividerItemDecorationVERTICAL)
        recycler.addItemDecoration(dividerItemDecorationHORIZONTAL)
        viewModel.selected.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun openGameCard(game : GameBl){
        //fragmentControl.openNewFragment(FilmInfoFragment.newInstance(game))
    }

    private fun deleteGame(game : GameBl){
        //viewModel.deleteFilm(film)
    }


    private fun observeLaunches() {
        lifecycleScope.launch {
           // viewModel.getList()
            adapter.submitList(viewModel.getList())
//            viewModel.gamesListFlow.collectLatest {
//                adapter.submitList(it)
//            }
        }
    }







}