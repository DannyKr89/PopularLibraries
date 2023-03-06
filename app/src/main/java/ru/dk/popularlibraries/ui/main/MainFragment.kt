package ru.dk.popularlibraries.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.dk.popularlibraries.app
import ru.dk.popularlibraries.databinding.FragmentMainBinding
import ru.dk.popularlibraries.domain.UserEntity

class MainFragment : Fragment(), UsersContract.View {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = UsersAdapter()
    private lateinit var presenter: UsersContract.Presenter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        presenter = UsersPresenter(app.usersRepo)
        presenter.attach(this)
    }


    private fun initViews() {
        with(binding) {
            rvUsersList.layoutManager = LinearLayoutManager(app)
            rvUsersList.adapter = adapter
            btnRefresh.setOnClickListener {
                presenter.onRefresh()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        presenter.detach()
    }

    override fun showUsers(users: List<UserEntity>) {
        adapter.setData(users)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(app, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressbar(inProgress: Boolean) {
        with(binding) {
            rvUsersList.isVisible = !inProgress
            progress.isVisible = inProgress
            btnRefresh.isEnabled= !inProgress
        }
    }
}