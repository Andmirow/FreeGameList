package com.example.freegamelist.presentation.recycler_view_tools

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.freegamelist.databinding.ItemGameCardBinding
import com.example.freegamelist.domain.GameBl


class GameAdapter(private val onClickListener : ((GameBl)-> Unit), private val onLongClickListener : ((GameBl)-> Unit)) : ListAdapter<GameBl, GameViewHolder>(GameListDiffItemCallBack()) {

    private lateinit var binding : ItemGameCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        binding = ItemGameCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = getItem(position)
        when (binding){
            is ItemGameCardBinding -> {
                    Glide.with(binding.photo.context)
                        .load(game.thumbnail)
                        .centerCrop()
                        .into(binding.photo)
            }
        }
        binding.root.setOnClickListener {
            Log.e("TAG", "НАЖАЛ")
            onClickListener(game)
        }
        binding.root.setOnLongClickListener {
            Log.e("TAG", "сильно НАЖАЛ")
            onLongClickListener(game)
            return@setOnLongClickListener true
        }

    }
}