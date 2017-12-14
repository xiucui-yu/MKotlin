package com.self.xiucuiyu.mkotlin.ui.yuedan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.YueDanBean
import com.self.xiucuiyu.koltindemo.base.BaseFragment
import com.self.xiucuiyu.mkotlin.R
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListAdapter
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListFragment
import com.self.xiucuiyu.mkotlin.ui.homepage.view.HomeItemView
import com.self.xiucuiyu.mkotlin.ui.homepage.view.YueDanItemView

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class YueDanFragment : BaseListFragment<YueDanBean, YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun initAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }
    override fun getPageUseList(fromJson: YueDanBean): List<YueDanBean.PlayListsBean>? {
           return fromJson?.playLists
    }

}