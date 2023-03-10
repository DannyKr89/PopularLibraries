package ru.dk.popularlibraries.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserEntity(
    val login: String,
    val id: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String
) : Parcelable
