package com.example.freegamelist.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.freegamelist.data.room.GameListDao
import com.example.freegamelist.domain.GameRepository
import com.example.freegamelist.domain.GamesInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
class DefaultGameRepository @Inject constructor(
    private val gameListDao: GameListDao,
    private val gameRemoteMediator: GameRemoteMediator.Factory
) : GameRepository {

    override fun getGames(platform: String?): Flow<PagingData<GamesInterface>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE // not required, may be deleted
            ),
            remoteMediator = gameRemoteMediator.create(platform = platform),
            pagingSourceFactory = { gameListDao.getPagingSource(platform!!) }
        )
            .flow
            .map { it as PagingData<GamesInterface> }
//            .map { pagingData ->
//                pagingData.map { launchRoomEntity ->
//                    launchRoomEntity
//                }
//            }
    }

    override suspend fun makeNoties(game: GamesInterface) {
        TODO("Not yet implemented")
    }
    private companion object {
        const val PAGE_SIZE = 30
    }
}