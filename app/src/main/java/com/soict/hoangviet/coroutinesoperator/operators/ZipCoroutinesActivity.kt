package com.soict.hoangviet.coroutinesoperator.operators

import com.soict.hoangviet.coroutinesoperator.extension.zip
import com.soict.hoangviet.coroutinesoperator.model.User
import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception

class ZipCoroutinesActivity : BaseActivity() {

    override fun doSomeWork() {
        launch {
            showLog("Network Request")
            val pairUser = zip(getFirstUser(), getSecondUser()) { firstUser, secondUser ->
                Pair(firstUser, secondUser)
            }.await()
            showLog(pairUser)
        }
    }

    private suspend fun getFirstUser() = async {
        delay(1000)
        return@async User(name = "Android", age = 23)
    }

    private suspend fun getSecondUser() = async {
        delay(2000)
        return@async User(name = "IOS", age = 24)
    }
}