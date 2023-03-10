package ru.dk.popularlibraries.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.dk.popularlibraries.domain.UsersRepo


@Suppress("UNCHECKED_CAST")
class UsersViewModelFactory(private val repo: UsersRepo) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(repo) as T
    }
}