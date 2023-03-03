package ru.dk.popularlibraries

import android.app.Application
import androidx.fragment.app.Fragment

class App : Application() {
}
val Fragment.app: Application get() = requireContext().applicationContext as App
