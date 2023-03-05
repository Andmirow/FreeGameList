package com.example.freegamelist.data.retrofit

import com.example.freegamelist.data.retrofit.GameListModel.GameInfo
import com.example.freegamelist.data.retrofit.GameListModel.GameListItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("./games")
    suspend fun getGamesList(
        @Query("platform") platform : String,
        @Query("category") category : String
    ): List<GameListItem>


    @GET("./games")
    suspend fun getGamesList( @Query("platform") platform : Platform): List<GameListItem>

    @GET("./games")
    suspend fun getGamesList(): List<GameListItem>

    @GET("./game")
    suspend fun getGameInfo(
        @Query("id") id : String
    ): GameInfo


    @GET("./filter")
    suspend fun getGamesPersonalizedList(
        @Query("platform") platform : String,
        @Query("tag") tag : String
    ): List<GameListItem>


}