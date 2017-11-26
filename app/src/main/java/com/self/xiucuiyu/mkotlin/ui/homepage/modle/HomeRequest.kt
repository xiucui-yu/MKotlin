package com.self.xiucuiyu.mkotlin.ui.homepage.modle

import com.itheima.player.model.bean.HomeItemBean
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils

/**
 * Created by xiucui.yu on 2017/11/26.
 */
class HomeRequest(offset: Int, callBack: ResponseCallBack<List<HomeItemBean>>) : MRequest<List<HomeItemBean>>(URLProviderUtils.getHomeUrl(0, 10), callBack) {
}