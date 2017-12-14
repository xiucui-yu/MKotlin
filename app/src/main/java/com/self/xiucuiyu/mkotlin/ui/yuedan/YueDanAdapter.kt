package com.self.xiucuiyu.mkotlin.ui.yuedan

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import com.itheima.player.model.bean.YueDanBean
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListAdapter
import com.self.xiucuiyu.mkotlin.ui.homepage.view.HomeItemView
import com.self.xiucuiyu.mkotlin.ui.homepage.view.YueDanItemView

/**
 * Created by xiucui.yu on 2017/12/14.
 */
class YueDanAdapter() : BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView>() {
    override fun refreshView(itemView: YueDanItemView, get: YueDanBean.PlayListsBean) {
        itemView.setData(get)
    }

    override fun getItemView(context: Context?): YueDanItemView? {
        return YueDanItemView(context);
    }


}