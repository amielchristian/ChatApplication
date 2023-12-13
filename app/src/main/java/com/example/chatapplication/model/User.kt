package com.example.chatapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val username: String
) : Parcelable
