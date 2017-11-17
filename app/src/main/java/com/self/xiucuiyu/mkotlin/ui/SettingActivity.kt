package com.self.xiucuiyu.mkotlin.ui

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar

import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.utils.ToolBarManager
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * Created by xiucui.yu on 2017/11/16.
 */
class SettingActivity : BaseActivity(), ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        super.initData()
        initSettingToolBar();
        val defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val push = defaultSharedPreferences.getBoolean("push", false)
        myToast("push=$push")
    }


}