package com.self.xiucuiyu.mkotlin.ui.yuedan

import com.itheima.player.model.bean.YueDanBean
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.ui.homepage.BaseListPresenter
import com.self.xiucuiyu.mkotlin.ui.homepage.ListContract
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.YueDanRequest

/**
 * Created by xiucui.yu on 2017/11/22.
 *
 */
class YueDanPresenter(yuedanView: ListContract.View<YueDanBean>) : BaseListPresenter<YueDanBean, YueDanBean.PlayListsBean>(yuedanView) {
    override fun baseListRequest(offset: Int): YueDanRequest {
        return YueDanRequest(offset, this)
    }


}