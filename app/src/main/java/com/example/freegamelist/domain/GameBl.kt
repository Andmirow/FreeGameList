package com.example.freegamelist.domain

import android.graphics.Bitmap
import android.os.Parcelable
import com.example.freegamelist.data.retrofit.GameListModel.MinimumSystemRequirements
import com.example.freegamelist.data.retrofit.GameListModel.Screenshot
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameBl(
    val description: String?,
    val developer: String,
    val freetogame_profile_url: String,
    val game_url: String,
    val genre: String,
    val idRetrofit: Int,
    val idRoom : Int,
    val minimum_system: MinimumSystemBl?,
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
): Parcelable