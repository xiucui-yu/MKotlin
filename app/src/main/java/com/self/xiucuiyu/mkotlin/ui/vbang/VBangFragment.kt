package com.self.xiucuiyu.mkotlin.ui.vbang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class VBangFragment : BaseFragment() {
    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_vbang_layout,null)
    }
}