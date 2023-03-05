package com.example.freegamelist.domain

import android.graphics.Bitmap
import com.example.freegamelist.data.retrofit.GameListModel.Screenshot

interface GamesInterface {
    val description: String?
    val developer: String
    val freetogame_profile_url: String
    val game_url: String
    val genre: String

    val idRetrofit: Int
    val idRoom : Int

    val platform: String
    val publisher: String
    val release_date: String
    val screenshots: List<Screenshot>?
    val short_description: String
    val status: String?
    val thumbnail: String
    val title: String


    val graphics: String
    val memory: String
    val os: String
    val processor: String
    val storage: String


    val notes : String
    var isFavorite : Boolean

}