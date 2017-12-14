package com.self.xiucuiyu.mkotlin.ui.mv

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.itheima.player.model.bean.MvAreaBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment

/**
 * Created by xiucui.yu on 2017/12/14.
 */
class MvPagerAdapter(fm: FragmentManager, val tabData: List<MvAreaBean>?) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return tabData?.size ?: 0//为null0 else size
    }

    override fun getItem(position: Int): BaseFragment {
        val mvChildFragment = MvChildFragment();
        val bundle = Bundle()
        bundle.putString("title", tabData!!.get(position).name)
        mvChildFragment.arguments = bundle
        return mvChildFragment
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return  tabData!!.get(position).name
    }
}