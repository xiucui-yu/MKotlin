package com.self.xiucuiyu.mkotlin.ui.mv

import com.itheima.player.model.bean.MvAreaBean
import com.self.xiucuiyu.mkotlin.net.NetManager
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.MvTitleRequest

/**
 * Created by xiucui.yu on 2017/12/14.
 */
class MVPresenterImpl(val mvFragment: MVFragment) : MvContract.MvPresenter {
    override fun getTitleData() {
        NetManager.instance.sendRequest("", MvTitleRequest(object : ResponseCallBack<ArrayList<MvAreaBean>> {
            override fun onSuccess(tag: String, response: ArrayList<MvAreaBean>) {
                mvFragment.setTopTab(response)
            }

            override fun onError(tag: String, msg: String?) {

            }

        }))
    }

    init {
        mvFragment.presenter = this
    }

}