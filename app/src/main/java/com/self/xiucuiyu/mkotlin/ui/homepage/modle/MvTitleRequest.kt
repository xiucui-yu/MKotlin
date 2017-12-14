package com.self.xiucuiyu.mkotlin.ui.homepage.modle

import com.itheima.player.model.bean.MvAreaBean
import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.utils.URLProviderUtils

/**
 * Created by xiucui.yu on 2017/12/14.
 */
class MvTitleRequest(callBack: ResponseCallBack<ArrayList<MvAreaBean>>) : MRequest<ArrayList<MvAreaBean>>(URLProviderUtils.getMVareaUrl(), callBack) {
}