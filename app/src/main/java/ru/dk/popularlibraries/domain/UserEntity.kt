package ru.dk.popularlibraries.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserEntity(
    val login: String,
    val id: Int,
    val avatarUrl: String
) : Parcelable
