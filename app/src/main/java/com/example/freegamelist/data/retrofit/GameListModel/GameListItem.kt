package com.example.freegamelist.data.retrofit.GameListModel

import com.example.freegamelist.domain.GamesInterface
import com.google.gson.annotations.SerializedName

data class GameListItem (
    override val developer: String,
    override val freetogame_profile_url: String,
    override val game_url: String,
    override val genre: String,
    @SerializedName("id") override val idRetrofit: Int,
    override val platform: String,
    override val publisher: String,
    override val release_date: String,
    override val short_description: String,
    override val thumbnail: String,
    override val title: String

):GamesInterface {

    override val description: String? get() = "-"
    override val idRoom: Int
        get() = 0
    override val screenshots: List<Screenshot>?
        get() = null
    override val status: String?
        get() = "-"
    override val graphics: String
        get() = "-"
    override val memory: String
        get() = "-"
    override val os: String
        get() = "-"
    override val processor: String
        get() = "-"
    override val storage: String
        get() = "-"
    override val notes: String
        get() = "-"
    override var isFavorite: Boolean
        get() = false
        set(value) {}

}