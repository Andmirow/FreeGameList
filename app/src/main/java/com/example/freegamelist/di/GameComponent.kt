package com.example.freegamelist.di

import com.example.freegamelist.domain.MyApp
import dagger.Component

@Component(modules = [RetrofitModule::class])
interface GameComponent {

    fun inject(activity: MyApp)
}