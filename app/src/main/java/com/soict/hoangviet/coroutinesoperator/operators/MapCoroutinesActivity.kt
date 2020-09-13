package com.soict.hoangviet.coroutinesoperator.operators

import com.soict.hoangviet.coroutinesoperator.model.User
import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception

class MapCoroutinesActivity : BaseActivity() {

    override fun doSomeWork() {
        launch {
            val listUsers = withContext(Dispatchers.IO) {
                getItem()
                    .map { user ->
                        user.age += user.age
                        return@map user
                    }
            }
            showLog(listUsers)
        }
    }

    private suspend fun getItem() = async {
        delay(1000)
        return@async listOf(
            User(name = "Android", age = 23),
            User(name = "IOS", age = 24),
            User(name = "Flutter", age = 25)
        )
    }.await()
}