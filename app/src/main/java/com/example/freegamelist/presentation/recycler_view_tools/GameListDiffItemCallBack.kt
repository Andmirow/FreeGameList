package com.example.freegamelist.presentation.recycler_view_tools

import androidx.recyclerview.widget.DiffUtil
import com.example.freegamelist.domain.GameBl



class GameListDiffItemCallBack : DiffUtil.ItemCallback<GameBl>() {

    override fun areItemsTheSame(oldItem: GameBl, newItem: GameBl): Boolean {
        return oldItem.idRetrofit == newItem.idRetrofit && oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: GameBl, newItem: GameBl): Boolean {
        return oldItem == newItem
    }
}