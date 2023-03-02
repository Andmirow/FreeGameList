package com.example.freegamelist.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MinimumSystemBl(

    val id : String,
    val graphics: String,
    val memory: String,
    val os: String,
    val processor: String,
    val storage: String

) : Parcelable