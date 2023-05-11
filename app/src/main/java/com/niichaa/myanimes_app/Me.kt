package com.niichaa.myanimes_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Me(
    val name: String,
    val email: String
) : Parcelable
