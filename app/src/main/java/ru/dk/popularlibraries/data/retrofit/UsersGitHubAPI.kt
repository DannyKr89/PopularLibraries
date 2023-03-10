package ru.dk.popularlibraries.data.retrofit

import retrofit2.Call
import retrofit2.http.GET
import ru.dk.popularlibraries.domain.UserEntity

interface UsersGitHubAPI {
    @GET("users")
    fun getListUsers(): Call<List<UserEntity>>
}