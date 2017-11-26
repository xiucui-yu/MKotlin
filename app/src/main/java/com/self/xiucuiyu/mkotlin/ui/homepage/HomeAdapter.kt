package com.self.xiucuiyu.mkotlin.ui.homepage

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.itheima.player.model.bean.HomeItemBean
import com.self.xiucuiyu.mkotlin.ui.homepage.view.HomeItemView
import com.self.xiucuiyu.mkotlin.widget.LodeMoreItemView

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