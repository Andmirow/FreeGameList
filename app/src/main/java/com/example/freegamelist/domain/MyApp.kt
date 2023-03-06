package com.example.freegamelist.domain

import android.app.Application
import com.example.freegamelist.data.retrofit.GameApi
import com.example.freegamelist.di.DaggerGameComponent
import javax.inject.Inject


class MyApp : Application() {

    @Inject
    lateinit var gameApi : GameApi


    override fun onCreate() {
        DaggerGameComponent.builder().build().inject(this)
        super.onCreate()
    }

}