package com.self.xiucuiyu.koltindemo.base

import android.os.Bundle
import android.os.Looper
import android.os.PersistableBundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

/**
 * Created by xiucui.yu on 2017/10/31.
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData();
        initListener();
    }

    open protected fun initData() {

    }

    open protected fun initListener() {

    }

    abstract fun getLayoutId(): Int


    open protected fun myToast(msg: String) {
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            toast(msg)
        } else
            toast(msg)
    }

    inline fun <reified T : BaseActivity> startActivityAndFinish() {
        startActivity<T>();
        finish()
    }

}