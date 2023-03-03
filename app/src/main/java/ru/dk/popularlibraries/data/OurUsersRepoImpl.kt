package ru.dk.popularlibraries.data

import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import ru.dk.popularlibraries.domain.UserEntity
import ru.dk.popularlibraries.domain.UsersRepo


class OurUsersRepoImpl : UsersRepo {

    private val data: List<UserEntity> = listOf(
        UserEntity("mojombo", 1, "https://avatars.githubusercontent.com/u/1?v=4"),
        UserEntity("defunkt", 2, "https://avatars.githubusercontent.com/u/2?v=4"),
        UserEntity("pjhyett", 3, "https://avatars.githubusercontent.com/u/3?v=4"),
        UserEntity("wycats", 4, "https://avatars.githubusercontent.com/u/4?v=4"),
        UserEntity("ezmobius", 5, "https://avatars.githubusercontent.com/u/5?v=4"),
        UserEntity("ivey", 6, "https://avatars.githubusercontent.com/u/6?v=4"),
        UserEntity("evanphx", 7, "https://avatars.githubusercontent.com/u/7?v=4"),
        UserEntity("vanpelt", 8, "https://avatars.githubusercontent.com/u/17?v=4"),
        UserEntity("wayneeseguin", 9, "https://avatars.githubusercontent.com/u/18?v=4"),
        UserEntity("brynary", 10, "https://avatars.githubusercontent.com/u/19?v=4"),
        UserEntity("kevinclark", 11, "https://avatars.githubusercontent.com/u/20?v=4"),
    )

    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed(2000) {
            if ((0..3).random() == 1) {
                onError?.let { it(Throwable("Ошибочка")) }
            }
            onSuccess(data)
        }
    }
}