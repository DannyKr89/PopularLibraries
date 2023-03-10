package ru.dk.popularlibraries.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.dk.popularlibraries.R
import ru.dk.popularlibraries.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MainFragment.newInstance())
                .commit()
        }
    }
}