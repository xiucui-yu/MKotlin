package com.self.xiucuiyu.mkotlin.ui.mv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.MvAreaBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.NetManager
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListPresenter
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.MvTitleRequest
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_mv_layout.*

/**
    * Created by xiucui.yu on 2017/11/17.
    */
    class MVFragment : BaseFragment(), MvContract.MvView {
        override fun setTopTab(tabData: ArrayList<MvAreaBean>) {
            val mvPagerAdapter = MvPagerAdapter(childFragmentManager, tabData)
            viewpager.adapter = mvPagerAdapter
            tab_top.setupWithViewPager(viewpager)

        }

    override lateinit var presenter: MvContract.MvPresenter

    override fun initView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_mv_layout, null)
    }

    override fun initData() {
        super.initData()

        presenter.getTitleData();


    }

    override fun initListener() {
        super.initListener()
    }
}