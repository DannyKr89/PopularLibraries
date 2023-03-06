package ru.dk.popularlibraries

import android.app.Application
import androidx.fragment.app.Fragment
import ru.dk.popularlibraries.data.OurUsersRepoImpl
import ru.dk.popularlibraries.domain.UsersRepo
import ru.dk.popularlibraries.ui.users.UsersContract
import ru.dk.popularlibraries.ui.users.UsersPresenter

class App : Application() {
    private val usersRepo: UsersRepo by lazy { OurUsersRepoImpl() }
    val presenter: UsersContract.Presenter by lazy { UsersPresenter(usersRepo) }
}

val Fragment.app: App get() = requireContext().applicationContext as App
