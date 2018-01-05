package com.self.xiucuiyu.mkotlin.ui.mv

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.BaseAdapter

/**
 * Created by xiucui.yu on 2018/1/5.
 */
class VideoAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        val mvVideoFragment = MvVideoFragment()
        return mvVideoFragment

    }
}

