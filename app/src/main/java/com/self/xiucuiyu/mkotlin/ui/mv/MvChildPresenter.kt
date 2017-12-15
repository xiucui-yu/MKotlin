package com.self.xiucuiyu.mkotlin.ui.mv

import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.model.bean.VideosBean
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListPresenter
import com.self.xiucuiyu.mkotlin.ui.homepage.ListContract
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.MvChildRequest

/**
 * Created by xiucui.yu on 2017/12/15.
 */
class MvChildPresenter(homeView: ListContract.View<MvPagerBean>, val name: String) : BaseListPresenter<MvPagerBean, VideosBean>(homeView) {
    override fun baseListRequest(offset: Int): MRequest<MvPagerBean> {
        return MvChildRequest(this, name, offset)
    }
}