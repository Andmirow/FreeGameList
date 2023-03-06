package com.example.freegamelist.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.freegamelist.data.retrofit.Platform
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    fun getGames(platform: String? = null): Flow<PagingData<GamesInterface>>


    suspend fun getFavoriteGames() : LiveData<List<GamesInterface>>?
    suspend fun addGame(game : GamesInterface)

    suspend fun makeNoties(game: GamesInterface)

}