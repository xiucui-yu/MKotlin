package com.self.xiucuiyu.mkotlin.utils

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.SettingActivity
import java.util.*

/**
 * Created by xiucui.yu on 2017/11/16.
 */
interface ToolBarManager {
    val toolbar: Toolbar
    fun initHomeToolBar() {
        toolbar.title = "首页"
        toolbar.inflateMenu(R.menu.main)
        //如果java 接口只有一个未实现的方法，可以省略接口对象
        toolbar.setOnMenuItemClickListener {
            when (it?.itemId) {
                R.id.setting -> {
                    //TODO 跳转到设置页面   SettingActivity::class.java java 类的class
                    toolbar.context.startActivity(Intent(toolbar.context, SettingActivity::class.java));
                }
            }
            true
        }
    }

    fun initSettingToolBar() {
        toolbar.title = "设置"
    }
    fun initAboutToolBar() {
        toolbar.title = "关于我"
    }
}