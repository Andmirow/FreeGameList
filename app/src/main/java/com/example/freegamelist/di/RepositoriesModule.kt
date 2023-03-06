package com.example.freegamelist.di

import androidx.paging.ExperimentalPagingApi
import com.example.freegamelist.data.GameRepositoryImpl
import com.example.freegamelist.domain.GameRepository
import dagger.Binds
import dagger.Module

@ExperimentalPagingApi
@Module
interface RepositoriesModule {

    @Binds
    fun bindGameRepository(
        gameRepository: GameRepositoryImpl
    ): GameRepository

}