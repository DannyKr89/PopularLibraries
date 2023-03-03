package ru.dk.popularlibraries.domain

data class UserEntity(
    val login: String,
    val id: Int,
    val avatarUrl: String
)
