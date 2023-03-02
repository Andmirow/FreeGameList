package com.example.freegamelist.data.room.database

import androidx.room.PrimaryKey

data class MinimumSystemDb(

    @PrimaryKey(autoGenerate = true)
    val id : String,

    val graphics: String,
    val memory: String,
    val os: String,
    val processor: String,
    val storage: String
)
