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
import ru.dk.popularlibraries.domain.UsersRepo

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = UsersAdapter()
    private val usersRepo: UsersRepo by lazy { app.usersRepo }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    }

    private fun loadData() {
        showProgressbar(true)
        showProgressbar(isVisible)
        usersRepo.getUsers(onSuccess = {
            adapter.setData(it)
            showProgressbar(false)
        }, onError = {
            Toast.makeText(app, it.message, Toast.LENGTH_SHORT).show()
            showProgressbar(false)
        })
    }

    private fun showProgressbar(inProgress: Boolean) {
        with(binding) {
            rvUsersList.isVisible = !inProgress
            progress.isVisible = inProgress
        }
    }

    private fun initViews() {
        with(binding) {
            rvUsersList.layoutManager = LinearLayoutManager(app)
            rvUsersList.adapter = adapter
            btnRefresh.setOnClickListener {
                loadData()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}