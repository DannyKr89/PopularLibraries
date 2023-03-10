package ru.dk.popularlibraries

import android.app.Application
import androidx.fragment.app.Fragment
import ru.dk.popularlibraries.data.OurUsersRepoImpl
import ru.dk.popularlibraries.domain.UsersRepo

class App : Application() {
    val usersRepo: UsersRepo by lazy { OurUsersRepoImpl() }
}

val Fragment.app: App get() = requireContext().applicationContext as App
