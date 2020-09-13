package com.soict.hoangviet.coroutinesoperator.operators

import android.util.Log
import com.soict.hoangviet.coroutinesoperator.extension.flatMap
import com.soict.hoangviet.coroutinesoperator.model.User
import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.Exception

class FlatMapCoroutinesActivity : BaseActivity() {

    override fun doSomeWork() {
        launch {
            val listValue = withContext(Dispatchers.IO) {
                getItem().flatMap {
                    async {
                        getDetailItem(it)
                    }
                }
            }
            listValue.await().forEach {
                showLog(it.await())
            }
        }
    }

    private suspend fun getItem() = async {
        delay(1000)
        return@async listOf(1..10).flatten()
    }

    private suspend fun getDetailItem(item: Int) = async {
        when {
            item % 2 == 0 -> {
                return@async "$item - Event"
            }
            else -> {
                return@async "$item - Odd"
            }
        }
    }.await()
}