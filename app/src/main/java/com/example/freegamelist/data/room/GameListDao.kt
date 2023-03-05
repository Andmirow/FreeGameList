package com.example.freegamelist.data.room

import androidx.paging.PagingSource
import androidx.room.*
import com.example.freegamelist.data.retrofit.Platform
import com.example.freegamelist.data.retrofit.Tag
import com.example.freegamelist.data.room.GameDbModel
import io.reactivex.Single

@Dao
interface GameListDao {

    @Query("SELECT * FROM games WHERE :platform IS NULL OR platform = :platform")
    fun getPagingSource(
        platform : String
    ): PagingSource<String, GameDbModel>

    @Query("SELECT * FROM games")
    suspend fun getListGames() : List<GameDbModel>

    @Query("SELECT * FROM games WHERE platform=:platform")
    suspend fun getListGames(platform : Platform) : List<GameDbModel>

    @Query("SELECT * FROM games WHERE genre=:genre")
    suspend fun getListGame(genre : String) : List<GameDbModel>

    @Query("SELECT * FROM games WHERE platform=:platform and genre=:genre")
    suspend fun getListGames(platform : Platform, genre : String) : List<GameDbModel>

    @Query("SELECT * FROM games WHERE idRoom=:id")
    suspend fun getGame(id : Int) : List<GameDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(gameDbModels: List<GameDbModel>)

    suspend fun save(gameDbModel: GameDbModel) {
        save(listOf(gameDbModel))
    }

    @Query("DELETE FROM games WHERE :platform IS NULL OR platform = :platform AND isFavorite = 'false'")
    suspend fun clear(platform : String?)

    @Transaction
    suspend fun refresh(platform: String?, games: List<GameDbModel>) {
        clear(platform)
        save(games)
    }


}