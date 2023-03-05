package com.example.freegamelist.data.room

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.freegamelist.data.retrofit.GameListModel.MinimumSystemRequirements
import com.example.freegamelist.data.retrofit.GameListModel.Screenshot
import com.example.freegamelist.data.retrofit.Platform
import com.example.freegamelist.domain.GamesInterface

@Entity(tableName = "games")
data class GameDbModel(

    @PrimaryKey(autoGenerate = true)
    override val idRoom : Int,

    override val description: String?,
    override val developer: String,
    override val freetogame_profile_url: String,
    override val game_url: String,
    override val genre: String,
    override val idRetrofit: Int,
    override val platform: String,
    override val publisher: String,
    override val release_date: String,
    override val screenshots: List<Screenshot>?,
    override val short_description: String,
    override val status: String?,
    override val thumbnail: String,
    override val title: String,
    override val notes : String,
    override var isFavorite : Boolean,
    override val graphics: String,
    override val memory: String,
    override val os: String,
    override val processor: String,
    override val storage: String
) : GamesInterface{

    constructor( game : GamesInterface) : this(
        idRoom = game.idRoom,
        description = game.description,
        developer = game.developer,
        freetogame_profile_url = game.freetogame_profile_url,
        game_url = game.game_url,
        genre = game.genre,
        idRetrofit = game.idRetrofit,
        platform = game.platform,
        publisher = game.publisher,
        release_date = game.release_date,
        screenshots = game.screenshots,
        short_description = game.short_description,
        status = game.status,
        thumbnail = game.thumbnail,
        title = game.title,
        notes = game.notes,
        isFavorite = game.isFavorite,
        graphics = game.graphics,
        memory = game.memory,
        os = game.os,
        processor = game.processor,
        storage = game.storage
    )


}