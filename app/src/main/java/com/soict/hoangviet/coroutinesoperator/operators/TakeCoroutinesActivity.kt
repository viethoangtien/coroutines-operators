package com.soict.hoangviet.coroutinesoperator.operators

import android.util.Log
import com.soict.hoangviet.coroutinesoperator.extension.flatMap
import com.soict.hoangviet.coroutinesoperator.model.User
import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception

class TakeCoroutinesActivity : BaseActivity() {
    companion object {
        const val ITEMS_TAKEN = 5
    }

    override fun doSomeWork() {
        launch {
            val listValue = withContext(Dispatchers.IO) {
                getItem().take(ITEMS_TAKEN)
            }
            showLog(listValue)
        }
    }

    private suspend fun getItem() = async {
        delay(1000)
        return@async listOf(1..10).flatten()
    }.await()
}