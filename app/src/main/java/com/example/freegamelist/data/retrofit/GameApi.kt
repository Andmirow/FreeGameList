package com.example.freegamelist.data.retrofit

import com.example.freegamelist.data.retrofit.GameListModel.GameInfo
import com.example.freegamelist.data.retrofit.GameListModel.GameListItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("./games")
    fun getGamesList(
        @Query("platform") platform : String,
        @Query("category") category : String,
        @Query("sort-by") sortBy : String
    ): Single<List<GameListItem>>

    @GET("./games")
    fun getGamesList(): Single<List<GameListItem>>


    @GET("./game")
    fun getGameInfo(
        @Query("id") id : String
    ): Single<GameInfo>


    @GET("./filter")
    fun getGamesPersonalizedList(
        @Query("platform") platform : String,
        @Query("tag") tag : String
    ): Single<List<GameListItem>>


}