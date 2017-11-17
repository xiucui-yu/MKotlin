package com.self.xiucuiyu.mkotlin.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import kotlinx.android.synthetic.main.fragment_home_layout.*

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class HomeFragment : BaseFragment() {
    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home_layout, null)
    }

    override fun initListener() {
        super.initListener()
        //初始化
        recyclerView.layoutManager=LinearLayoutManager(context);
        //适配

    }
}