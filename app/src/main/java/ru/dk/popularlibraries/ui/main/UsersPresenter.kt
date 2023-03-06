package ru.dk.popularlibraries.ui.main

import ru.dk.popularlibraries.domain.UsersRepo

class UsersPresenter(private val usersRepo: UsersRepo) : UsersContract.Presenter {

    private var view: UsersContract.View? = null

    override fun attach(view: UsersContract.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun onRefresh() {
        loadData()
    }

    private fun loadData() {
        view?.showProgressbar(true)
        usersRepo.getUsers(onSuccess = {
            view?.showUsers(it)
            view?.showProgressbar(false)
        }, onError = {
            view?.showError(it)
            view?.showProgressbar(false)
        })
    }
}