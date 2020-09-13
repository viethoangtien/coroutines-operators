package com.soict.hoangviet.coroutinesoperator.operators

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MergeCoroutinesActivity : BaseActivity() {

    override fun doSomeWork() {
        launch {
            async { getFirstList() }
            async { getSecondList() }
        }
    }

    private suspend fun getFirstList() = repeat(3) {
        delay(1000)
        showLog("A $it")
    }

    private suspend fun getSecondList() = repeat(5) {
        delay(1000)
        showLog("B $it")
    }

}