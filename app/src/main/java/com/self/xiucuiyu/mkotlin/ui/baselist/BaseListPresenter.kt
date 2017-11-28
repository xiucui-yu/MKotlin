package com.self.xiucuiyu.mkotlin.ui.homepage

import com.self.xiucuiyu.mkotlin.net.MRequest
import com.self.xiucuiyu.mkotlin.net.NetManager
import com.self.xiucuiyu.mkotlin.net.ResponseCallBack

/**
 * Created by xiucui.yu on 2017/11/22.
 *
 */
abstract class BaseListPresenter<ITENBEAN>(var homeView: ListContract.View<ITENBEAN>) : ListContract.Presenter, ResponseCallBack<List<ITENBEAN>> {

    override fun onSuccess(tag: String, response: List<ITENBEAN>) {
        when (tag) {
            REFRESH -> homeView.refreshSuccess(response)
            LOADMORE -> homeView.loadMoreSuccess(response)
        }
    }

    override fun onError(tag: String, msg: String?) {
        when (tag) {
            REFRESH -> homeView.refreshError(msg)
            LOADMORE -> homeView.loadMoreError(msg)
        }
    }

    companion object {
        private val REFRESH: String = "refresh"
        private val LOADMORE: String = "loadMore"
    }

    init {
        homeView.presenter = this
    }

    override fun loadMore(offset: Int) {
        NetManager.instance.sendRequest(
                LOADMORE,
                baseListRequest(offset)
        )

    }

    abstract fun baseListRequest(offset: Int): MRequest<List<ITENBEAN>>

    override fun start() {
        loadData();
    }

    private fun loadData() {
        NetManager.instance.sendRequest(REFRESH, baseListRequest(0))

    }

}