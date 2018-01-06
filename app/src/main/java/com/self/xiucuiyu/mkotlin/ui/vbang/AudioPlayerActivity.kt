package com.self.xiucuiyu.mkotlin.ui.vbang

import com.self.xiucuiyu.koltindemo.base.BaseActivity
import com.self.xiucuiyu.mkotlin.R

/**
 * Created by xiucui.yu on 2018/1/6.
 */
class AudioPlayerActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.audio_detail_layout
    }

    override fun initData() {
        super.initData()
        val parcelableArrayExtra = intent.getParcelableArrayExtra("list")
        val intExtra = intent.getIntExtra("position", 0)


    }
}