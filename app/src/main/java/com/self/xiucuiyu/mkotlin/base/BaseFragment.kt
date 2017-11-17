package com.self.xiucuiyu.koltindemo.base

import android.os.Bundle
import android.os.Looper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger

/**
 * Created by xiucui.yu on 2017/10/31.
 */
abstract class BaseFragment : Fragment(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init();
    }

    open protected fun init() {

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initView(inflater, container, savedInstanceState)
    }

    abstract fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener();
        initData()
    }

    open protected fun initData() {
        //To change body of created functions use File | Settings | File Templates.
    }

    open protected fun initListener() { //To change body of created functions use File | Settings | File Templates.
    }

    open protected fun toast(msg: String) {
        if (Thread.currentThread() != Looper.getMainLooper().thread) {
            toast(msg)
        }
        toast(msg)
    }
}