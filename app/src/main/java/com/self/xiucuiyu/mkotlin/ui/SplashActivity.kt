package com.self.xiucuiyu.mkotlin.ui

import android.support.v4.view.ViewCompat

import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by xiucui.yu on 2017/10/31.
 */
open class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        super.initData()
        ViewCompat.animate(imageView)
    }

}