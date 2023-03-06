package com.example.freegamelist.di

import androidx.paging.ExperimentalPagingApi
import com.example.freegamelist.domain.MyApp
import dagger.Component

@OptIn(ExperimentalPagingApi::class)
@Component(modules = [RetrofitModule::class, RepositoriesModule::class])
interface GameComponent {

    fun inject(activity: MyApp)
}