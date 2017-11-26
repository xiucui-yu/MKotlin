package com.self.xiucuiyu.mkotlin.ui.homepage

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View

import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.homepage.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by xiucui.yu on 2017/10/31.
 */
open class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationEnd(view: View?) {
        startActivityAndFinish<HomeActivity>();

    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        super.initData()
        ViewCompat.animate(imageView).scaleX(1f).scaleY(1f).setListener(this)
    }

}