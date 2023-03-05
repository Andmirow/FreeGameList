package com.example.freegamelist.data.retrofit.GameListModel

import com.example.freegamelist.domain.GamesInterface

data class GameInfo(
    override val description: String,
    override val developer: String,
    override val freetogame_profile_url: String,
    override val game_url: String,
    override val genre: String,
    val id: Int,
    val minimum_system_requirements: MinimumSystemRequirements,
    override val platform: String,
    override val publisher: String,
    override val release_date: String,
    override val screenshots: List<Screenshot>,
    override val short_description: String,
    override val status: String,
    override val thumbnail: String,
    override val title: String
): GamesInterface {

    override val idRetrofit: Int
        get() = id
    override val idRoom: Int
        get() = 0
    override val graphics: String
        get() = minimum_system_requirements.graphics
    override val memory: String
        get() = minimum_system_requirements.memory
    override val os: String
        get() = minimum_system_requirements.os
    override val processor: String
        get() = minimum_system_requirements.processor
    override val storage: String
        get() = minimum_system_requirements.storage
    override val notes: String
        get() = "-"
    override var isFavorite: Boolean
        get() = false
        set(value) {}

}