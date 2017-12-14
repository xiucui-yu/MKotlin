package com.self.xiucuiyu.mkotlin.ui.homepage.modle

import com.itheima.player.model.bean.YueDanBean
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils

/**
 * Created by xiucui.yu on 2017/11/26.
 */
class YueDanRequest(offset: Int, callBack: ResponseCallBack<YueDanBean>) : MRequest<YueDanBean>(URLProviderUtils.getYueDanUrl(offset, 10), callBack) {
}