package ru.dk.popularlibraries.domain

import java.io.Closeable

interface UsersRepo : Closeable {
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )

    override fun close() {
    }
}