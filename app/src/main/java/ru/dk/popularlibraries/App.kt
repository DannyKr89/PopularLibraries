package ru.dk.popularlibraries

import android.app.Application
import androidx.fragment.app.Fragment
import ru.dk.popularlibraries.data.GitHubUsersRepoImpl
import ru.dk.popularlibraries.domain.UsersRepo

class App : Application() {
    val usersRepo: UsersRepo by lazy { GitHubUsersRepoImpl() }
}

val Fragment.app: App get() = requireContext().applicationContext as App
