package com.self.xiucuiyu.mkotlin.ui.homepage.modle

import com.itheima.player.model.bean.MvPagerBean
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils

/**
 * Created by xiucui.yu on 2017/12/15.
 */
class MvChildRequest(callBack: ResponseCallBack<MvPagerBean>, area: String, offset: Int) : MRequest<MvPagerBean>(URLProviderUtils.getMVListUrl(area,offset,10), callBack) {
}