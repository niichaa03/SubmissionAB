package com.niichaa.myanimes_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val title: String,
    val description: String,
    val photo: Int,
    val status: String,
    val skor: String
) : Parcelable
