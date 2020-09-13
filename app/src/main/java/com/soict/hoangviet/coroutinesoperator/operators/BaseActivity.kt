package com.soict.hoangviet.coroutinesoperator.operators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.soict.hoangviet.coroutinesoperator.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {
    private val throwableHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        showError(throwable)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + throwableHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doSomeWork()
    }

    protected fun showError(throwable: Throwable) {
        Log.e("myLog", throwable.toString())
    }

    protected fun showLog(value: Any?) {
        Log.e("myLog", value.toString())
    }

    abstract fun doSomeWork()
}