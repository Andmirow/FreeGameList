package com.example.freegamelist.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.freegamelist.data.retrofit.GameApi
import com.example.freegamelist.data.retrofit.Platform
import com.example.freegamelist.data.retrofit.Tag
import com.example.freegamelist.data.room.GameDbModel
import com.example.freegamelist.data.room.GameListDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit

@ExperimentalPagingApi
class GameRemoteMediator @AssistedInject constructor(
    private val GamesDao: GameListDao,
    private val gamesApi: GameApi,
    @Assisted private val platform: Platform?,
    @Assisted private val genre: Tag?,
) : RemoteMediator<String, GameDbModel>()  {

    private var pageIndex = 0

    override suspend fun load(loadType: LoadType, state: PagingState<String, GameDbModel>): MediatorResult {

        pageIndex = getPageIndex(loadType) ?:
                return MediatorResult.Success(endOfPaginationReached = true)

        val limit = state.config.pageSize
        val offset = pageIndex * limit

        return try {
            val gamesList = fetchGames(platform, genre)
            if (loadType == LoadType.REFRESH) {
                GamesDao.refresh(platform, gamesList)
            } else {
                GamesDao.save(games)
            }
            MediatorResult.Success(
                endOfPaginationReached = games.size < limit
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }

    }

    private fun getPageIndex(loadType: LoadType): Int? {
        pageIndex = when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> return null
            LoadType.APPEND -> ++pageIndex
        }
        return pageIndex
    }

    private suspend fun fetchGames(platform: Platform?,genre: Tag?): List<GameDbModel> {
        return gamesApi.getGamesList()
            .map { GameDbModel(it) }
    }




    @AssistedFactory
    interface Factory {
        fun create(platform: String?): GameRemoteMediator
    }
}