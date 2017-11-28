package com.self.xiucuiyu.mkotlin.ui.homepage

import android.content.Context
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeItemBean
import com.self.xiucuiyu.mkotlin.ui.homepage.view.HomeItemView

/**
 * Created by xiucui.yu on 2017/11/17.
 */
class HomeAdapter() : BaseListAdapter<HomeItemBean, HomeItemView>() {
    override fun refreshView(itemView: HomeItemView, get: HomeItemBean) {
        itemView.setData(get)
    }

    override fun getItemView(context: Context?): HomeItemView? {
        return HomeItemView(context)
    }
}