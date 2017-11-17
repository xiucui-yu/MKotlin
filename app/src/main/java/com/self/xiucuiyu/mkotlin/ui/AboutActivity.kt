package com.self.xiucuiyu.mkotlin.ui

import android.support.v7.widget.Toolbar
import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.utils.ToolBarManager
import org.jetbrains.anko.find

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class AboutActivity : BaseActivity(), ToolBarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_about_layout
    }
    override fun initData() {
        super.initData()
        initAboutToolBar()
    }
}