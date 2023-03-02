package com.example.freegamelist.data.room.database

import android.graphics.Bitmap
import androidx.room.PrimaryKey
import com.example.freegamelist.data.retrofit.GameListModel.MinimumSystemRequirements
import com.example.freegamelist.data.retrofit.GameListModel.Screenshot

data class GameDbModel(

    @PrimaryKey(autoGenerate = true)
    val idRoom : Int,


    val description: String?,
    val developer: String,
    val freetogame_profile_url: String,
    val game_url: String,
    val genre: String,
    val idRetrofit: Int,

    val minimum_system: MinimumSystemDb?,

    val platform: String,
    val publisher: String,
    val release_date: String,
    val screenshots: List<Screenshot>?,
    val short_description: String,
    val status: String?,
    val thumbnail: String,
    val title: String,
    val previewImage : Bitmap?,
    val notes : String,
    var isFavorite : Boolean


)