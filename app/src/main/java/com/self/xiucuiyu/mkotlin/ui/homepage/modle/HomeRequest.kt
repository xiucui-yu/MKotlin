package com.self.xiucuiyu.mkotlin.ui.homepage.modle

import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils

/**
 * Created by xiucui.yu on 2017/11/26.
 */
class HomeRequest<RESPONSE>(offset: Int, callBack: ResponseCallBack<List<RESPONSE>>) : MRequest<List<RESPONSE>>(URLProviderUtils.getHomeUrl(offset, 10), callBack) {
}