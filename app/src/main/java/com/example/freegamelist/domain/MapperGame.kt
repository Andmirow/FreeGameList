package com.example.freegamelist.domain

import com.example.freegamelist.data.retrofit.GameListModel.GameListItem

class MapperGame {
    companion object{

        fun mapGameItemToGameBl(gameItem : GameListItem): GameBl {
            return GameBl(
                idRetrofit = gameItem.id,
                idRoom = 0,
                short_description = gameItem.short_description,
                developer = gameItem.developer,
                freetogame_profile_url = gameItem.freetogame_profile_url,
                game_url = gameItem.game_url,
                genre = gameItem.genre,
                minimum_system = null,
                platform = gameItem.platform,
                publisher = gameItem.publisher,
                release_date = gameItem.release_date,
                screenshots = null,
                description = null,
                status = null,
                thumbnail = gameItem.thumbnail,
                title = gameItem.title,
                previewImage = null,
                notes = "",
                isFavorite = false
            )
        }

        fun mapListGameItemToListGameBl(listGameItem : List<GameListItem>) = listGameItem.map {
            mapGameItemToGameBl(it)
        }






    }
}