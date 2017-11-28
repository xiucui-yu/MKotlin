package com.self.xiucuiyu.mkotlin.ui.homepage

import com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeItemBean
import com.self.xiucuiyu.mkotlin.ui.homepage.modle.HomeRequest

/**
 * Created by xiucui.yu on 2017/11/22.
 *
 */
class HomePresenter(homeView: ListContract.View<HomeItemBean>) : BaseListPresenter<HomeItemBean>(homeView) {
    override fun baseListRequest(offset: Int): HomeRequest<HomeItemBean> {
        return HomeRequest(offset, this)
    }

/*(var homeView: ListContract.View) : ListContract.Presenter, ResponseCallBack<List<HomeItemBean>> {
    override fun onSuccess(tag: String, response: List<HomeItemBean>) {
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
        NetManager.instance.sendRequest(LOADMORE, HomeRequest(
                offset, this))

    }

    override fun start() {
        loadData();
    }

    private fun loadData() {
        NetManager.instance.sendRequest(REFRESH, HomeRequest(
                0, this))

    }
*/
}