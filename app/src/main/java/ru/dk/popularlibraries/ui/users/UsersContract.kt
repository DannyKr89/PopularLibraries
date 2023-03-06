package ru.dk.popularlibraries.ui.users

import ru.dk.popularlibraries.domain.UserEntity

interface UsersContract {

    interface View {
        fun showUsers(users: List<UserEntity>)
        fun showError(throwable: Throwable)
        fun showProgressbar(inProgress: Boolean)
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun onRefresh()
    }
}