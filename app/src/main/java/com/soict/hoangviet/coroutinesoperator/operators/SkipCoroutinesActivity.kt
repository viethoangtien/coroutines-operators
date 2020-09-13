package com.soict.hoangviet.coroutinesoperator.operators

import android.util.Log
import com.soict.hoangviet.coroutinesoperator.extension.flatMap
import com.soict.hoangviet.coroutinesoperator.model.User
import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception

class SkipCoroutinesActivity : BaseActivity() {

    override fun doSomeWork() {
        launch {
            val listValue = withContext(Dispatchers.IO) {
                getItem().drop(5)
            }
            showLog(listValue)
        }
    }

    private suspend fun getItem() = async {
        delay(1000)
        return@async listOf(1..10).flatten()
    }.await()
}