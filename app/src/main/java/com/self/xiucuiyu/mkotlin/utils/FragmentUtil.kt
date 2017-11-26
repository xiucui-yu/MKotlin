package com.self.xiucuiyu.mkotlin.utils

import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListFragment
import com.self.xiucuiyu.mkotlin.ui.homepage.HomeFragment
import com.self.xiucuiyu.mkotlin.ui.mv.MVFragment
import com.self.xiucuiyu.mkotlin.ui.vbang.VBangFragment
import com.self.xiucuiyu.mkotlin.ui.yuedan.YueDanFragment

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class FragmentUtil private constructor() {
    private val homeFragment by lazy { HomeFragment() }
    private val mvFragment by lazy { MVFragment() }
    private val vBangFragment by lazy { VBangFragment() }
    private val yueDanFragment by lazy { YueDanFragment() }


    //半生对象
    companion object {
        //线程安全的操作
        val fragmentUtil by lazy { FragmentUtil() }
    }

    fun getFragment(tabID: Int): BaseFragment? {
        when (tabID) {
            R.id.tab_home -> {
                return homeFragment;
            }
            R.id.tab_mv -> return mvFragment;
            R.id.tab_vbang -> return vBangFragment;
            R.id.tab_yuedan -> return yueDanFragment;
        }
        return null
    }
}