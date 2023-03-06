package ru.dk.popularlibraries.ui.users

import ru.dk.popularlibraries.domain.UserEntity
import ru.dk.popularlibraries.domain.UsersRepo

class UsersPresenter(private val usersRepo: UsersRepo) : UsersContract.Presenter {

    private var view: UsersContract.View? = null

    private var usersList: List<UserEntity>? = null
    private var inProgress: Boolean = false

    override fun attach(view: UsersContract.View) {
        this.view = view
        view.showProgressbar(inProgress)
        usersList?.let { view.showUsers(it) }

    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgressbar(true)
        inProgress = true
        usersRepo.getUsers(onSuccess = {
            view?.showUsers(it)
            view?.showProgressbar(false)
            usersList = it
            inProgress = false
        }, onError = {
            view?.showError(it)
            view?.showProgressbar(false)
            inProgress = false
        })
    }
}