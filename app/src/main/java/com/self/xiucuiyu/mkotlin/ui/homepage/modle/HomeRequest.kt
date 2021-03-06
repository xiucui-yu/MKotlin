package com.self.xiucuiyu.mkotlin.ui.homepage.modle

import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils

/**
 * Created by xiucui.yu on 2017/11/26.
 */
class HomeRequest(offset: Int, callBack: ResponseCallBack<List<com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeItemBean>>) : MRequest<List<com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeItemBean>>(URLProviderUtils.getHomeUrl(offset, 10), callBack) {
}